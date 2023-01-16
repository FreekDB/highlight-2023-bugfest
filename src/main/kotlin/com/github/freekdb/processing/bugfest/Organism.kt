package com.github.freekdb.processing.bugfest

import processing.core.PApplet
import processing.core.PGraphics
import processing.core.PImage
import processing.core.PVector

// This class contains some general fields and methods.

const val LEFT_SIDE = "left side"
const val RIGHT_SIDE = "right side"

abstract class Organism(
    private val parentApplet: PApplet, private val columnWidth: Int, private val rowHeight: Int,
    private val designModeActive: Boolean, private val designImage: PImage?
) : PGraphics() {
    init {
        this.setParent(parentApplet)
//        this.setPrimary(false)
//        this.setSize(parentApplet.width, parentApplet.height)
    }

    var mainBackgroundColor: Int = 0

    fun draw() {
        if (designModeActive) {
            parentApplet.image(
                designImage,
                columnWidth / 2f,
                rowHeight / 2f,
                columnWidth.toFloat(),
                rowHeight.toFloat()
            )
        } else {
            drawOrganism()
        }
    }

    abstract fun getOrganismData(): OrganismData

    private fun drawOrganism() {
        getOrganismData().parts.forEach { part ->
            if (part.fill == FillStyle.RANDOM) {
                randomFill()
            } else if (part.fill == FillStyle.BACKGROUND) {
                parentApplet.fill(mainBackgroundColor)
            } else if (part.fill == FillStyle.SPECIFIC_COLOR) {
                parentApplet.fill(part.fillColor ?: 0)
            }

            val points = part.points.map { PVector(it.x * columnWidth, it.y * rowHeight) }
            // todo: The range should be part of OrganismData (or of the sub objects).
            val randomizedPoints = calculateRandomizedPoints(points, 0.02f)

            if (part.operation == DrawOperation.CURVE_VERTEX || part.operation == DrawOperation.LINE_VERTEX) {
                drawVertexShape(randomizedPoints, LEFT_SIDE, part.shapeMode ?: CLOSE, part.operation)

                if (part.sides == Sides.BOTH) {
                    drawVertexShape(randomizedPoints, RIGHT_SIDE, part.shapeMode ?: CLOSE, part.operation)
                }
            } else if (part.operation == DrawOperation.ELLIPSE && points.size == 2) {
                parentApplet.ellipse(points[0].x, points[0].y, points[1].x, points[1].y)
            }
        }
    }

    private fun drawVertexShape(
        points: List<PVector>, side: String, shapeMode: Int? = null, operation: DrawOperation
    ) {
        val saveStrokeWeight = parentApplet.g.strokeWeight

        if (operation == DrawOperation.CURVE_VERTEX) {
            parentApplet.beginShape()
        } else if (operation == DrawOperation.LINE_VERTEX) {
            parentApplet.strokeWeight(4f)
            parentApplet.beginShape(LINES)
        }

        // Do the first point twice.
        val xFirst = if (side == LEFT_SIDE) points[0].x else columnWidth - points[0].x

        if (operation == DrawOperation.CURVE_VERTEX) {
            parentApplet.curveVertex(xFirst, points[0].y)
        } else if (operation == DrawOperation.LINE_VERTEX) {
            parentApplet.vertex(xFirst, points[0].y)
        }

        for (point in points) {
            val x = if (side == LEFT_SIDE) point.x else columnWidth - point.x

            if (operation == DrawOperation.CURVE_VERTEX) {
                parentApplet.curveVertex(x, point.y)
            } else if (operation == DrawOperation.LINE_VERTEX) {
                parentApplet.vertex(x, point.y)
            }
        }

        if (shapeMode != null) {
            parentApplet.endShape(shapeMode)
        } else {
            parentApplet.endShape()
        }

        parentApplet.strokeWeight(saveStrokeWeight)
    }

    fun calculateRandomizedPoints2D(points: List<List<PVector>>, range: Float): List<List<PVector>> {
        return points.map { row -> row.map { point -> randomizePoint(point, range) } }
    }

    private fun calculateRandomizedPoints(points: List<PVector>, range: Float): List<PVector> {
        return points.map { point -> randomizePoint(point, range) }
    }

    fun randomizePoints(points: List<MutableList<PVector>>, range: Float): List<MutableList<PVector>> {
        for (partIndex in points.indices) {
            for (pointIndex in 1 until points[partIndex].size) {
                points[partIndex][pointIndex] = randomizePoint(points[partIndex][pointIndex], range)
            }
        }

        return points
    }

    fun randomizePoint(point: PVector, range: Float): PVector {
        return PVector(
            point.x * parent.random(1 - range, 1 + range),
            point.y * parent.random(1 - range, 1 + range)
        )
    }

    /**
     * Set the fill color to a random color.
     */
    private fun randomFill() {
        parentApplet.fill(
            parentApplet.color(
                parentApplet.random(255f), parentApplet.random(255f), parentApplet.random(255f)
            )
        )
    }
}


enum class FillStyle {
    RANDOM,
    BACKGROUND,
//    COLOR_BLACK,
    SPECIFIC_COLOR
}


enum class Sides {
    BOTH,
    LEFT_ONLY
}


enum class DrawOperation {
    CURVE_VERTEX,
    LINE_VERTEX,
    ELLIPSE
}


data class OrganismData(val parts: List<OrganismPart>)


data class OrganismPart(
    val description: String = "",
    val fill: FillStyle? = null,
    val fillColor: Int? = null,
    val operation: DrawOperation,
    val sides: Sides = Sides.BOTH,
    val shapeMode: Int? = null,
    val points: List<OrganismPoint> = emptyList()
)


data class OrganismPoint(val x: Float, val y: Float)
