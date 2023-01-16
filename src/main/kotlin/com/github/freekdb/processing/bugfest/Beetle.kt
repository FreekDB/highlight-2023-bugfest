package com.github.freekdb.processing.bugfest

import processing.core.PApplet
import processing.core.PImage

@Suppress("unused")
class Beetle(
    parentApplet: PApplet, columnWidth: Int, rowHeight: Int, designImage: PImage?
) : Organism(parentApplet, columnWidth, rowHeight, false, designImage) {
    override fun getOrganismData() = OrganismData(
        parts = listOf(
            OrganismPart(
                description = "body points",
                fill = FillStyle.RANDOM,
                operation = DrawOperation.CURVE_VERTEX,
                points = listOf(
                    OrganismPoint(0.50f, 0.57f),
                    OrganismPoint(0.47f, 0.55f),
                    OrganismPoint(0.45f, 0.45f),
                    OrganismPoint(0.46f, 0.42f),
                    OrganismPoint(0.48f, 0.39f),
                    OrganismPoint(0.50f, 0.40f),
                    OrganismPoint(0.50f, 0.57f),
                )
            ),
            OrganismPart(
                description = "head points",
                fill = FillStyle.RANDOM,
                operation = DrawOperation.CURVE_VERTEX,
                points = listOf(
                    OrganismPoint(0.50f, 0.40f),
                    OrganismPoint(0.48f, 0.38f),
                    OrganismPoint(0.48f, 0.35f),
                    OrganismPoint(0.50f, 0.34f),
                    OrganismPoint(0.50f, 0.33f),
                    OrganismPoint(0.50f, 0.39f),
                )
            ),
            OrganismPart(
                description = "antenna points",
                fill = FillStyle.BACKGROUND,
                operation = DrawOperation.CURVE_VERTEX,
                points = listOf(
                    OrganismPoint(0.48f, 0.34f),
                    OrganismPoint(0.46f, 0.26f),
                    OrganismPoint(0.45f, 0.23f),
                    OrganismPoint(0.44f, 0.20f),
                )
            ),
            OrganismPart(
                description = "hindleg points",
                fill = FillStyle.BACKGROUND,
                operation = DrawOperation.CURVE_VERTEX,
                shapeMode = OPEN,
                points = listOf(
                    OrganismPoint(0.47f, 0.56f),
                    OrganismPoint(0.46f, 0.61f),
                    OrganismPoint(0.43f, 0.64f),
                    OrganismPoint(0.41f, 0.66f),
                )
            ),
            OrganismPart(
                description = "middleleg points",
                fill = FillStyle.BACKGROUND,
                operation = DrawOperation.CURVE_VERTEX,
                shapeMode = OPEN,
                points = listOf(
                    OrganismPoint(0.45f, 0.46f),
                    OrganismPoint(0.43f, 0.48f),
                    OrganismPoint(0.40f, 0.49f),
                    OrganismPoint(0.38f, 0.51f),
                )
            ),
            OrganismPart(
                description = "foreleg points",
                fill = FillStyle.BACKGROUND,
                operation = DrawOperation.CURVE_VERTEX,
                shapeMode = OPEN,
                points = listOf(
                    OrganismPoint(0.46f, 0.42f),
                    OrganismPoint(0.46f, 0.36f),
                    OrganismPoint(0.43f, 0.31f),
                    OrganismPoint(0.41f, 0.27f),
                )
            ),
        )
    )
}
