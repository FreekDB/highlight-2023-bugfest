package com.github.freekdb.processing.bugfest

import processing.core.PApplet
import processing.core.PImage
import processing.core.PVector

class Butterfly(
    private val parentApplet: PApplet, private val columnWidth: Int, private val rowHeight: Int, designImage: PImage?
) : Organism(parentApplet, columnWidth, rowHeight, false, designImage) {
    init {
        setParent(parentApplet)
    }

    private val butterflyPoints = mutableListOf(mutableListOf<PVector>())

    private val layerPoints = mutableListOf<PVector>()
    private val innerPoints = mutableListOf<PVector>()
    private val randomRange = 0.3f
    private val colorCount = 8
    private var innerShapeCount = 6
    private var middlePoint = PVector(0f, 0f)
    private var middleFactor = 0.3f
    private val colors = mutableListOf<Int>()
//    private var backgroundColor = color(0)

    private fun initialize() {
        backgroundColor = parentApplet.color(
            parentApplet.random(255f), parentApplet.random(255f), parentApplet.random(255f)
        )
        middleFactor = parentApplet.random(0.1f, 0.5f)
        innerShapeCount = parentApplet.random(2f, 10f).toInt()

        butterflyPoints.clear()
        butterflyPoints.add(
            mutableListOf(
                // Body points.
                PVector(0.5f * columnWidth, 0.2f * rowHeight),
                PVector(0.45f * columnWidth, 0.5f * rowHeight),
                PVector(0.5f * columnWidth, 0.6f * rowHeight),
            )
        )
        butterflyPoints.add(
            mutableListOf(
                // Lower wing.
                PVector(0.5f * columnWidth, 0.3f * rowHeight),
                PVector(0.45f * columnWidth, 0.6f * rowHeight),
                PVector(0.35f * columnWidth, 0.7f * rowHeight),
                PVector(0.25f * columnWidth, 0.5f * rowHeight),
            )
        )
        butterflyPoints.add(
            mutableListOf(
                // Upper wing.
                PVector(columnWidth / 2f, rowHeight / 3f),
                PVector(columnWidth / 2.5f, rowHeight / 6f),
                PVector(columnWidth / 4f, rowHeight / 9f),
                PVector(columnWidth / 9f, rowHeight / 7f),
                PVector(columnWidth / 6f, rowHeight / 3f),
                PVector(columnWidth / 4f, rowHeight / 2f),
            )
        )
        butterflyPoints.add(
            mutableListOf(
                // Antenna points.
                PVector(columnWidth / 2f, 0.2f * rowHeight),
                PVector(columnWidth / 2.1f, 0.01f * rowHeight),
                PVector(columnWidth / 2.3f, 0.01f * rowHeight),
            )
        )
    }

//    override fun drawOrganism() {
//            initialize()
//            randomizeButterflyPoints(butterflyPoints)
//
//            parentApplet.fill(colors[0])
//
//            // Draw the head.
//            parentApplet.ellipse(
//                this.columnWidth / 2.03f,
//                this.rowHeight / 5f,
//                0.1f * this.rowHeight,
//                0.1f * this.rowHeight
//            )
//            parentApplet.ellipse(
//                this.columnWidth / 1.97f,
//                this.rowHeight / 5f,
//                0.1f * this.rowHeight,
//                0.1f * this.rowHeight
//            )
//
//            // todo
//            for (layerIndex in butterflyPoints.indices) {
//                // Copy butterflyPoints to layerPoints and calculate the center position.
//                layerPoints.clear()
//                middlePoint = PVector(0f, 0f)
//
//                for (pointIndex in butterflyPoints[layerIndex].indices) {
//                    layerPoints.add(butterflyPoints[layerIndex][pointIndex])
//                    middlePoint.add(layerPoints[pointIndex])
//                }
//
//                middlePoint.div(butterflyPoints[layerIndex].size.toFloat())
//
//                parentApplet.fill(colors[(3 * layerIndex) % colorCount])
//
//                // Draw the outer edge of the left and right wings.
//                drawShape(layerPoints, LEFT_SIDE, CLOSE)
//                drawShape(layerPoints, RIGHT_SIDE, CLOSE)
//
//                for (innerShapeIndex in 0 until innerShapeCount) {
//                    val decorationPoints = mutableListOf<PVector>()
//                    innerPoints.clear()
//
//                    for (pointIndex in layerPoints.indices) {
//                        decorationPoints.add(layerPoints[pointIndex])
//                        innerPoints.add(mid(layerPoints[pointIndex], middlePoint, middleFactor))
//                        decorationPoints.add(this.innerPoints[pointIndex])
//                    }
//
//                    fill(this.colors[(3 * layerIndex + innerShapeIndex) % colorCount])
//
//                    // Draw the internal decoration of the left and right wings.
//                    drawShape(decorationPoints, LEFT_SIDE, CLOSE)
//                    drawShape(decorationPoints, RIGHT_SIDE, CLOSE)
//
//                    layerPoints.clear()
//                    layerPoints.addAll(innerPoints)
//                }
//
//                val starPoints = mutableListOf<PVector>()
//
//                for (pointIndex in 0 until innerPoints.size) {
//                    starPoints.add(innerPoints[pointIndex])
//                    starPoints.add(middlePoint)
//                }
//
//                // Draw the internal star shape of the left and right wings.
//                drawShape(starPoints, LEFT_SIDE, CLOSE)
//                drawShape(starPoints, RIGHT_SIDE, CLOSE)
//            }
//            // todo
//
//            val antennaPoints = mutableListOf<PVector>()
//
//            for (pointIndex in 0 until butterflyPoints[butterflyPoints.size - 1].size) {
//                antennaPoints.add(butterflyPoints[butterflyPoints.size - 1][pointIndex])
//            }
//
//            // Draw the left and right antenna.
//            drawShape(antennaPoints, LEFT_SIDE)
//            drawShape(antennaPoints, RIGHT_SIDE)
//    }

    private fun randomizeButterflyPoints(points: MutableList<MutableList<PVector>>, range: Float = randomRange) {
        for (layerIndex in 0 until points.size) {
            for (pointIndex in 1 until points[layerIndex].size - 1) {
                if (layerIndex != 0 || pointIndex != 3) {
                    points[layerIndex][pointIndex] = randomizePoint(points[layerIndex][pointIndex], range)
                }
            }
        }
    }

    private fun mid(vector1: PVector, vector2: PVector, factor: Float): PVector {
        return PVector(vector1.x + factor * (vector2.x - vector1.x), vector1.y + factor * (vector2.y - vector1.y))
    }

    override fun getOrganismData(): OrganismData {
        initialize()

        colors.clear()
        for (colorIndex in 0 until colorCount) {
            colors.add(
                parentApplet.color(
                    parentApplet.random(255f), parentApplet.random(255f), parentApplet.random(255f)
                )
            )
        }

        val dynamicOrganismParts = mutableListOf<OrganismPart>()

        var lastFillColorIndex = 0

        for (layerIndex in 0..3) {
            layerPoints.clear()
            middlePoint = PVector(0f, 0f)

            for (pointIndex in butterflyPoints[layerIndex].indices) {
                layerPoints.add(butterflyPoints[layerIndex][pointIndex])
                middlePoint.add(layerPoints[pointIndex])
            }

            middlePoint.div(butterflyPoints[layerIndex].size.toFloat())

            // Draw the outer edge of the left and right wings.
            dynamicOrganismParts.add(
                OrganismPart(
                    description = "butterfly ${layerIndex + 1}",
                    fill = FillStyle.SPECIFIC_COLOR,
                    fillColor = colors[(3 * layerIndex) % colorCount],
                    operation = DrawOperation.CURVE_VERTEX,
                    shapeMode = CLOSE,
                    points = layerPoints.map { OrganismPoint(it.x / columnWidth, it.y / rowHeight) }
                )
            )

            for (innerShapeIndex in 0 until innerShapeCount) {
                val decorationPoints = mutableListOf<PVector>()
                innerPoints.clear()

                for (pointIndex in layerPoints.indices) {
                    decorationPoints.add(layerPoints[pointIndex])
                    innerPoints.add(mid(layerPoints[pointIndex], middlePoint, middleFactor))
                    decorationPoints.add(this.innerPoints[pointIndex])
                }

                lastFillColorIndex = (3 * layerIndex + innerShapeIndex) % colorCount

                // Draw the internal decoration of the left and right wings.
                dynamicOrganismParts.add(
                    OrganismPart(
                        description = "butterfly ${layerIndex + 1}.${innerShapeIndex + 1}",
                        fill = FillStyle.SPECIFIC_COLOR,
                        fillColor = colors[lastFillColorIndex],
                        operation = DrawOperation.CURVE_VERTEX,
                        shapeMode = CLOSE,
                        points = decorationPoints.map { OrganismPoint(it.x / columnWidth, it.y / rowHeight) }
                    )
                )

                layerPoints.clear()
                layerPoints.addAll(innerPoints)
            }
        }

        val starPoints = mutableListOf<PVector>()

        for (pointIndex in 0 until innerPoints.size) {
            starPoints.add(innerPoints[pointIndex])
            starPoints.add(middlePoint)
        }

        // Draw the internal star shape of the left and right wings.
        dynamicOrganismParts.add(
            OrganismPart(
                description = "star shapes",
                fill = FillStyle.SPECIFIC_COLOR,
                fillColor = colors[lastFillColorIndex],
                operation = DrawOperation.CURVE_VERTEX,
                shapeMode = CLOSE,
                points = starPoints.map { OrganismPoint(it.x / columnWidth, it.y / rowHeight) }
            )
        )

//        dynamicOrganismParts.add(
//            OrganismPart(
//                description = "body points",
//                fill = FillStyle.SPECIFIC_COLOR,
//                fillColor = colors[0],
//                operation = DrawOperation.CURVE_VERTEX,
//                shapeMode = CLOSE,
//                points = listOf(
//                    OrganismPoint(0.5f, 0.2f),
//                    OrganismPoint(0.45f, 0.5f),
//                    OrganismPoint(0.5f, 0.6f),
//                )
//            )
//        )
//        dynamicOrganismParts.add(
//            OrganismPart(
//                description = "lower wing",
//                // fill = FillStyle.COLOR_BLACK, INDEXED_COLOR
//                operation = DrawOperation.CURVE_VERTEX,
//                shapeMode = CLOSE,
//                points = listOf(
//                    OrganismPoint(0.5f, 0.3f),
//                    OrganismPoint(0.45f, 0.6f),
//                    OrganismPoint(0.35f, 0.7f),
//                    OrganismPoint(0.25f, 0.5f),
//                )
//            )
//        )
//        dynamicOrganismParts.add(
//            OrganismPart(
//                description = "upper wing",
//                // fill = FillStyle.COLOR_BLACK, INDEXED_COLOR
//                operation = DrawOperation.CURVE_VERTEX,
//                shapeMode = CLOSE,
//                points = listOf(
//                    OrganismPoint(1 / 2f, 1 / 3f),
//                    OrganismPoint(1 / 2.5f, 1 / 6f),
//                    OrganismPoint(1 / 4f, 1 / 9f),
//                    OrganismPoint(1 / 9f, 1 / 7f),
//                    OrganismPoint(1 / 6f, 1 / 3f),
//                    OrganismPoint(1 / 4f, 1 / 2f),
//                )
//            )
//        )
//
//        // todo: This will be overwritten?
//        dynamicOrganismParts.add(
//            OrganismPart(
//                description = "antenna",
//                // fill = FillStyle.COLOR_BLACK, INDEXED_COLOR
//                operation = DrawOperation.CURVE_VERTEX,
//                shapeMode = CLOSE,
//                points = listOf(
//                    // Antenna points.
//                    OrganismPoint(1 / 2f, 0.2f),
//                    OrganismPoint(1 / 2.1f, 0.01f),
//                    OrganismPoint(1 / 2.3f, 0.01f),
//                )
//            )
//        )

        return OrganismData(
            listOf(
                OrganismPart(
                    description = "head 1",
                    fill = FillStyle.SPECIFIC_COLOR,
                    fillColor = colors[0],
                    operation = DrawOperation.ELLIPSE,
                    shapeMode = OPEN,
                    points = listOf(
                        OrganismPoint(1 / 2.03f, 1 / 5f),
                        OrganismPoint(0.1f, 0.1f),
                    )
                ),
                OrganismPart(
                    description = "head 2",
                    fill = FillStyle.SPECIFIC_COLOR,
                    fillColor = colors[0],
                    operation = DrawOperation.ELLIPSE,
                    shapeMode = OPEN,
                    points = listOf(
                        OrganismPoint(1 / 1.97f, 1 / 5f),
                        OrganismPoint(0.1f, 0.1f),
                    )
                )
            ) + dynamicOrganismParts + listOf(
                OrganismPart(
                    description = "antenna",
                    // fill = FillStyle.COLOR_BLACK,
                    operation = DrawOperation.CURVE_VERTEX,
                    shapeMode = CLOSE,
                    points = listOf(
                        OrganismPoint(1 / 2f, 0.2f),
                        OrganismPoint(1 / 2.1f, 0.01f),
                        OrganismPoint(1 / 2.3f, 0.01f),
                    )
                ),
            )
        )
    }
}
