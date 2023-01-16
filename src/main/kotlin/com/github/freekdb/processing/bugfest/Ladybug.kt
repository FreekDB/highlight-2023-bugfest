package com.github.freekdb.processing.bugfest

import processing.core.PApplet
import processing.core.PImage

class Ladybug(
    private val parentApplet: PApplet, private val columnWidth: Int, private val rowHeight: Int, designImage: PImage?
) : Organism(parentApplet, columnWidth, rowHeight, false, designImage) {
    init {
        this.setParent(parentApplet)
    }

    private val colorBlack = parentApplet.color(0)
    private val colorRed = parentApplet.color(231, 24, 9)
    private val colorOrange = parentApplet.color(255, 165, 0)
    private val colorYellow = parentApplet.color(255, 231, 0)
    private val colors = listOf(colorRed, colorOrange, colorYellow)

//    private var ladybugPoints = randomizePoints()
//
//    private fun randomizePoints() = randomizePoints(
//        listOf(
//            mutableListOf(
//                // Body points.
//                OrganismPoint(0.50f, 0.81f),
//                OrganismPoint(0.37f, 0.75f),
//                OrganismPoint(0.28f, 0.61f),
//                OrganismPoint(0.26f, 0.51f),
//                OrganismPoint(0.28f, 0.40f),
//                OrganismPoint(0.33f, 0.29f),
//                OrganismPoint(0.40f, 0.31f),
//                OrganismPoint(0.50f, 0.32f),
//            ),
//            mutableListOf(
//                // Head points.
//                OrganismPoint(0.50f, 0.32f),
//                OrganismPoint(0.42f, 0.31f),
//                OrganismPoint(0.34f, 0.29f),
//                OrganismPoint(0.38f, 0.22f),
//                OrganismPoint(0.43f, 0.19f),
//                OrganismPoint(0.47f, 0.17f),
//                OrganismPoint(0.50f, 0.17f),
//            ),
//            mutableListOf(
//                // Spot 1 points.
//                OrganismPoint(0.27f, 0.44f),
//                OrganismPoint(0.30f, 0.46f),
//                OrganismPoint(0.30f, 0.51f),
//                OrganismPoint(0.26f, 0.53f),
//                OrganismPoint(0.27f, 0.48f),
//            ),
//            mutableListOf(
//                // Spot 2 points.
//                OrganismPoint(0.39f, 0.53f),
//                OrganismPoint(0.42f, 0.54f),
//                OrganismPoint(0.45f, 0.57f),
//                OrganismPoint(0.45f, 0.61f),
//                OrganismPoint(0.41f, 0.61f),
//                OrganismPoint(0.38f, 0.58f),
//                OrganismPoint(0.38f, 0.56f),
//            ),
//            mutableListOf(
//                // Spot 3 points.
//                OrganismPoint(0.50f, 0.34f),
//                OrganismPoint(0.46f, 0.35f),
//                OrganismPoint(0.43f, 0.39f),
//                OrganismPoint(0.45f, 0.43f),
//                OrganismPoint(0.48f, 0.45f),
//                OrganismPoint(0.51f, 0.45f),
//            ),
//            mutableListOf(
//                // Foreleg points.
//                OrganismPoint(0.34f, 0.30f),
//                OrganismPoint(0.31f, 0.28f),
//                OrganismPoint(0.31f, 0.19f),
//                OrganismPoint(0.23f, 0.12f),
//                OrganismPoint(0.23f, 0.12f),
//            ),
//            mutableListOf(
//                // Middleleg points.
//                OrganismPoint(0.28f, 0.41f),
//                OrganismPoint(0.22f, 0.50f),
//                OrganismPoint(0.11f, 0.54f),
//                OrganismPoint(0.11f, 0.54f),
//            ),
//            mutableListOf(
//                // Hindleg points.
//                OrganismPoint(0.28f, 0.62f),
//                OrganismPoint(0.26f, 0.66f),
//                OrganismPoint(0.29f, 0.73f),
//                OrganismPoint(0.32f, 0.76f),
//                OrganismPoint(0.21f, 0.88f),
//                OrganismPoint(0.21f, 0.88f),
//            ),
//        ),
//        0.02f
//    )

//    override fun drawOrganism() {
//        ladybugPoints = randomizePoints()
//
//        // Draw the body.
//        parentApplet.fill(this.colors[parentApplet.random(colors.size.toFloat()).toInt()])
//
//        drawShape(ladybugPoints[0], LEFT_SIDE, CLOSE)
//        drawShape(ladybugPoints[0], RIGHT_SIDE, CLOSE)
//
//        // Draw the head.
//        parentApplet.fill(colorBlack)
//
//        drawShape(ladybugPoints[1], LEFT_SIDE, CLOSE)
//        drawShape(ladybugPoints[1], RIGHT_SIDE, CLOSE)
//
//        // Draw the spots.
//        fill(colorBlack)
//
//        for (spotIndex in 0..2) {
//            if (parentApplet.random(1f) <= 0.6f) {
//                drawShape(ladybugPoints[spotIndex + 2], LEFT_SIDE, CLOSE)
//                drawShape(ladybugPoints[spotIndex + 2], RIGHT_SIDE, CLOSE)
//            }
//        }
//
//        // Draw the legs.
//        parentApplet.stroke(0)
//        parentApplet.strokeWeight(3f)
//        parentApplet.fill(255)
//
//        for (legIndex in 0..2) {
//            drawShape(ladybugPoints[legIndex + 5], LEFT_SIDE)
//            drawShape(ladybugPoints[legIndex + 5], RIGHT_SIDE)
//        }
//
//        parentApplet.strokeWeight(1.5f)
//    }

    override fun getOrganismData(): OrganismData {
        val spotParts = mutableListOf<OrganismPart>()

        if (parentApplet.random(1f) <= 0.6f) {
            spotParts.add(
                OrganismPart(
                    description = "spot 1",
                    fill = FillStyle.SPECIFIC_COLOR,
                    fillColor = colorBlack,
                    operation = DrawOperation.CURVE_VERTEX,
                    shapeMode = CLOSE,
                    points = listOf(
                        OrganismPoint(0.27f, 0.44f),
                        OrganismPoint(0.30f, 0.46f),
                        OrganismPoint(0.30f, 0.51f),
                        OrganismPoint(0.26f, 0.53f),
                        OrganismPoint(0.27f, 0.48f),
                    )
                )
            )
        }

        if (parentApplet.random(1f) <= 0.6f) {
            spotParts.add(
                OrganismPart(
                    description = "spot 2",
                    fill = FillStyle.SPECIFIC_COLOR,
                    fillColor = colorBlack,
                    operation = DrawOperation.CURVE_VERTEX,
                    shapeMode = CLOSE,
                    points = listOf(
                        OrganismPoint(0.39f, 0.53f),
                        OrganismPoint(0.42f, 0.54f),
                        OrganismPoint(0.45f, 0.57f),
                        OrganismPoint(0.45f, 0.61f),
                        OrganismPoint(0.41f, 0.61f),
                        OrganismPoint(0.38f, 0.58f),
                        OrganismPoint(0.38f, 0.56f),
                    )
                )
            )
        }

        if (parentApplet.random(1f) <= 0.6f) {
            spotParts.add(
                OrganismPart(
                    description = "spot 3",
                    fill = FillStyle.SPECIFIC_COLOR,
                    fillColor = colorBlack,
                    operation = DrawOperation.CURVE_VERTEX,
                    shapeMode = CLOSE,
                    points = listOf(
                        OrganismPoint(0.50f, 0.34f),
                        OrganismPoint(0.46f, 0.35f),
                        OrganismPoint(0.43f, 0.39f),
                        OrganismPoint(0.45f, 0.43f),
                        OrganismPoint(0.48f, 0.45f),
                        OrganismPoint(0.51f, 0.45f),
                    )
                )
            )
        }

        return OrganismData(listOf(
            OrganismPart(
                description = "body",
                fill = FillStyle.SPECIFIC_COLOR,
                fillColor = colors[parentApplet.random(colors.size.toFloat()).toInt()],
                operation = DrawOperation.CURVE_VERTEX,
                shapeMode = CLOSE,
                points = listOf(
                    OrganismPoint(0.50f, 0.81f),
                    OrganismPoint(0.37f, 0.75f),
                    OrganismPoint(0.28f, 0.61f),
                    OrganismPoint(0.26f, 0.51f),
                    OrganismPoint(0.28f, 0.40f),
                    OrganismPoint(0.33f, 0.29f),
                    OrganismPoint(0.40f, 0.31f),
                    OrganismPoint(0.50f, 0.32f),
                    OrganismPoint(0.50f, 0.81f),
                )
            ),
            OrganismPart(
                description = "head",
                fill = FillStyle.SPECIFIC_COLOR,
                fillColor = colorBlack,
                operation = DrawOperation.CURVE_VERTEX,
                shapeMode = CLOSE,
                points = listOf(
                    OrganismPoint(0.50f, 0.32f),
                    OrganismPoint(0.42f, 0.31f),
                    OrganismPoint(0.34f, 0.29f),
                    OrganismPoint(0.38f, 0.22f),
                    OrganismPoint(0.43f, 0.19f),
                    OrganismPoint(0.47f, 0.17f),
                    OrganismPoint(0.50f, 0.17f),
                    OrganismPoint(0.50f, 0.32f),
                )
            )
        ) + spotParts + listOf(
            OrganismPart(
                description = "foreleg",
                fill = FillStyle.SPECIFIC_COLOR,
                fillColor = colorBlack,
                operation = DrawOperation.LINE_VERTEX,
                shapeMode = OPEN,
                points = listOf(
                    OrganismPoint(0.14f, 0.30f),
                    OrganismPoint(0.21f, 0.32f),
                    OrganismPoint(0.31f, 0.41f),
                    OrganismPoint(0.43f, 0.48f),
//                    OrganismPoint(0.23f, 0.12f),
                )
            ),
            OrganismPart(
                description = "middleleg",
                fill = FillStyle.SPECIFIC_COLOR,
                fillColor = colorBlack,
                operation = DrawOperation.LINE_VERTEX,
                shapeMode = OPEN,
                points = listOf(
                    OrganismPoint(0.28f, 0.41f),
                    OrganismPoint(0.22f, 0.50f),
                    OrganismPoint(0.11f, 0.54f),
//                    OrganismPoint(0.11f, 0.54f),
                )
            ),
            OrganismPart(
                description = "hindleg",
                fill = FillStyle.SPECIFIC_COLOR,
                fillColor = colorBlack,
                operation = DrawOperation.LINE_VERTEX,
                shapeMode = OPEN,
                points = listOf(
                    OrganismPoint(0.28f, 0.62f),
                    OrganismPoint(0.26f, 0.66f),
                    OrganismPoint(0.29f, 0.73f),
                    OrganismPoint(0.32f, 0.76f),
                    OrganismPoint(0.21f, 0.88f),
//                    OrganismPoint(0.21f, 0.88f),
                )
            )

//        // Draw the legs.
//        parentApplet.stroke(0)
//        parentApplet.strokeWeight(3f)
//        parentApplet.fill(255)

        ))
    }
}
