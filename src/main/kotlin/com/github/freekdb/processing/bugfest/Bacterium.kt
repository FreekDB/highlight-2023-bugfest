package com.github.freekdb.processing.bugfest

import processing.core.PApplet
import processing.core.PImage
import processing.core.PVector

class Bacterium(
    private val parentApplet: PApplet, columnWidth: Int, rowHeight: Int, designImage: PImage?
) : Organism(parentApplet, columnWidth, rowHeight, false, designImage) {
    init {
        this.setParent(parentApplet)
    }

    private val colorBlack = parentApplet.color(0)
    private val colorRed = parentApplet.color(231, 24, 9)
    private val colorOrange = parentApplet.color(255, 165, 0)
    private val colorYellow = parentApplet.color(255, 231, 0)
    private val colors = listOf(colorRed, colorOrange, colorYellow)

    private val bacteriumPoints = listOf(
        mutableListOf(
            // Body points.
            PVector(0.34f * columnWidth, 0.40f * rowHeight),
            PVector(0.42f * columnWidth, 0.66f * rowHeight),
            PVector(0.50f * columnWidth, 0.74f * rowHeight),
            PVector(0.56f * columnWidth, 0.75f * rowHeight),
            PVector(0.63f * columnWidth, 0.70f * rowHeight),
            PVector(0.66f * columnWidth, 0.58f * rowHeight),
            PVector(0.62f * columnWidth, 0.47f * rowHeight),
            PVector(0.56f * columnWidth, 0.31f * rowHeight),
            PVector(0.50f * columnWidth, 0.25f * rowHeight),
            PVector(0.44f * columnWidth, 0.24f * rowHeight),
            PVector(0.38f * columnWidth, 0.26f * rowHeight),
            PVector(0.35f * columnWidth, 0.32f * rowHeight),
            PVector(0.33f * columnWidth, 0.40f * rowHeight),
        ),
        mutableListOf(
            PVector(0.34f * columnWidth, 0.40f * rowHeight),
            PVector(0.29f * columnWidth, 0.38f * rowHeight),
            PVector(0.24f * columnWidth, 0.38f * rowHeight),
            PVector(0.20f * columnWidth, 0.39f * rowHeight),
            PVector(0.16f * columnWidth, 0.37f * rowHeight),
            PVector(0.14f * columnWidth, 0.35f * rowHeight),
        ),
        mutableListOf(
            PVector(0.38f * columnWidth, 0.56f * rowHeight),
            PVector(0.34f * columnWidth, 0.54f * rowHeight),
            PVector(0.29f * columnWidth, 0.58f * rowHeight),
            PVector(0.24f * columnWidth, 0.61f * rowHeight),
            PVector(0.19f * columnWidth, 0.61f * rowHeight),
        ),
        mutableListOf(
            PVector(0.59f * columnWidth, 0.35f * rowHeight),
            PVector(0.63f * columnWidth, 0.32f * rowHeight),
            PVector(0.69f * columnWidth, 0.31f * rowHeight),
            PVector(0.73f * columnWidth, 0.33f * rowHeight),
            PVector(0.76f * columnWidth, 0.31f * rowHeight),
            PVector(0.78f * columnWidth, 0.26f * rowHeight),
        ),
        mutableListOf(
            PVector(0.64f * columnWidth, 0.49f * rowHeight),
            PVector(0.69f * columnWidth, 0.50f * rowHeight),
            PVector(0.74f * columnWidth, 0.49f * rowHeight),
            PVector(0.78f * columnWidth, 0.49f * rowHeight),
            PVector(0.86f * columnWidth, 0.51f * rowHeight),
        ),
    )

//    override fun drawOrganism() {
//        randomizePoints(bacteriumPoints, 0.02f)
//
//        // Draw the body.
//        parentApplet.fill(colors[parentApplet.random(colors.size.toFloat()).toInt()])
//        drawShape(this.bacteriumPoints[0], LEFT_SIDE, CLOSE)
//
//        // Draw the legs.
//        parentApplet.stroke(colorBlack)
//        parentApplet.strokeWeight(1f)
//        parentApplet.fill(255)
//
//        for (legIndex in 0..3) {
//            drawShape(bacteriumPoints[legIndex + 1], LEFT_SIDE, CLOSE, LineStyle.LINE_VERTEX)
//        }
//    }

    override fun getOrganismData(): OrganismData {
        return OrganismData(emptyList())
    }
}
