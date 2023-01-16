package com.github.freekdb.processing.bugfest

import processing.core.PApplet
import processing.core.PImage
import processing.core.PVector

class DesignOrganism(
    parentApplet: PApplet, private val columnWidth: Int, private val rowHeight: Int, designImage: PImage?
) :
    Organism(parentApplet, columnWidth, rowHeight, false, designImage) {
    private val designPoints = mutableListOf<PVector>()
    private var designPointsClosed = false

    fun addPoint(point: PVector) {
        designPoints.add(point)
    }

    fun removeLastPoint() {
        designPoints.removeAt(designPoints.size - 1)
    }

    fun toggleDesignPointsClosed() {
        designPointsClosed = !designPointsClosed
    }

//    override fun drawOrganism() {
//        TODO("Not yet implemented")
//    }

//    // For the design mode, use row count 4 (for standardized sizes).
//    draw() {
//        for (let pointIndex = 0; pointIndex < this.designPoints.length; pointIndex++) {
//        circle(this.designPoints[pointIndex].x, this.designPoints[pointIndex].y, 4);
//    }
//
//        if (this.designPoints.length >= 3) {
//            if (this.designPointsClosed) {
//                this.drawShape(this.designPoints, this.com.github.freekdb.processing.bugfest.LEFT_SIDE, CLOSE);
//            }
//            else {
//                this.drawShape(this.designPoints, this.com.github.freekdb.processing.bugfest.LEFT_SIDE);
//            }
//        }
//    }

    fun printDesignPoints() {
        for (pointIndex in designPoints.indices) {
            PApplet.println(
                "PVector(" + "%.2f".format(designPoints[pointIndex].x / columnWidth) + " * columnWidth, " +
                        "%.2f".format(designPoints[pointIndex].y / rowHeight) + " * rowHeight),"
            )
        }
    }

    override fun getOrganismData(): OrganismData {
        return OrganismData(emptyList())
    }
}
