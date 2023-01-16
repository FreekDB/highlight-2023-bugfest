// Suppress unused warning for processing.pdf.PGraphicsPDF class.
@file:Suppress("UnusedImport")

package com.github.freekdb.processing.bugfest

import org.reflections.Reflections
import org.reflections.scanners.Scanners
import processing.core.PApplet
import processing.core.PGraphics
import processing.core.PImage
import processing.core.PVector
import processing.pdf.PGraphicsPDF

//import processing.pdf.PGraphicsPDF


// todo: Ask Jacob about plants.


fun main() {
    PApplet.main(Main::class.java)
}


class Main : PApplet() {
    private val animalClasses = getAnimalClasses()
    private val modes = animalClasses.map { it.name }
    private val modeToOrganismClass = animalClasses.associateBy { it.name }
    // private var mode = modes[0]
    private var mode = modes[3]
    private var play = true
    private var rotationActive = false
    private var designModeActive = false
    private var designAnimal = DesignOrganism(this, 0, 0, null)
    private var pdfNumber = 1

    override fun settings() {
        size(1024, 768)
        // fullScreen()
    }

    override fun setup() {
//        frameRate(2f)
//        noLoop()

        surface.setTitle("Butterflies, beetles and more: butterfly!");

        beginRecordPdf()

        randomSeed(1234)
        colorMode(RGB, 255f, 255f, 255f)
//        val backgroundColor = color(random(255f), random(255f), random(255f))
//        background(backgroundColor)
        strokeWeight(1.5f)
        strokeJoin(ROUND)
        imageMode(CENTER)

        // todo
//        butterflyImage = loadImage("https://mir-s3-cdn-cf.behance.net/project_modules/1400/60395395888605.5ea1c0315c764.jpg");
//        beetleDesignImage = loadImage("beetle-01.png");
//        ladybugDesignImage = loadImage("https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/40b97e58613507.5a02e49b918b1.jpg");
//        // caterpillars:
//        // https://www.researchgate.net/profile/Mark-Williams-49/publication/290193055/figure/fig7/AS:614287072563200@1523468859101/8-Structure-of-larva-or-caterpillar-of-a-butterfly-of-the-family-Lycaenidae.png
//        bacteriumDesignImage = loadImage("friendly-bacterium.png");
    }

    override fun draw() {
        // todo
        if (play) {
            beginRecordPdf()

            // val backgroundColor = color(random(255f), random(255f), random(255f))
            val backgroundColor = 255
            background(backgroundColor)
            // rowCount = int(random(1, 6))
            val rowCount = 1
            val rowHeight = height / rowCount
            // val columnCount = ((if (width > height) 1.5 else 0.75) * rowCount).toInt()
            val columnCount = 1
            val columnWidth = width / columnCount
            val designModeActive = false
            designAnimal = DesignOrganism(this, columnWidth, rowHeight, null)

            for (rowIndex in 0 until rowCount) {
                for (columnIndex in 0 until columnCount) {
                    push()

                    translate(columnIndex * columnWidth.toFloat(), 100 + rowIndex * rowHeight.toFloat())

//                if (rotationActive) {
//                    rotate(random(TWO_PI));
//                }

                    if (!designModeActive) {
                        val organismClass = modeToOrganismClass[mode]

                        if (organismClass != null) {
                            val organism = organismClass.getConstructor(
                                PApplet::class.java,
                                Int::class.java,
                                Int::class.java,
                                PImage::class.java
                            ).newInstance(this, columnWidth, rowHeight, null) as Organism

                            organism.mainBackgroundColor = backgroundColor
                            organism.draw()
                        }
                    }

                    pop()
                }
            }

            // nextPagePdf()
            endRecordPdf()

            play = false
        }
    }

    private var pdfRecorder: PGraphics? = null

    private fun beginRecordPdf() {
        // pdfRecorder = beginRecord(PDF, "bugfest-${"%06d".format(pdfNumber)}.pdf")
        // pdfRecorder = beginRecord(PDF, "bugfest-Pierre-$pdfNumber.pdf")
        pdfRecorder = beginRecord(PDF, "bugfest-Freek-$pdfNumber.pdf")
        pdfNumber++
    }

    private fun nextPagePdf() {
        if (pdfRecorder is PGraphicsPDF) {
            (pdfRecorder as PGraphicsPDF).nextPage()
        } else {
            println("Error creating the next page in the PDF document.")
        }
    }

    private fun endRecordPdf() {
        endRecord()
        // exit()
    }

    override fun mousePressed() {
        if (mouseButton == LEFT) {
            designAnimal.addPoint(PVector(mouseX.toFloat(), mouseY.toFloat()))
        } else if (mouseButton == RIGHT) {
            designAnimal.removeLastPoint()
        }

        if (!play) {
            play = true
        }
    }

    override fun keyPressed() {
        when (key) {
            'm', 'M' -> {
                mode = modes[(modes.indexOf(mode) + 1) % modes.size]
                val modeName = mode.substring(mode.lastIndexOf('.') + 1).lowercase()
                surface.setTitle("Butterflies, beetles and more: $modeName!");
                play = true
            }
            'r', 'R' -> rotationActive = !rotationActive
            'd', 'D' -> designModeActive = !designModeActive
            'c', 'C' -> designAnimal.toggleDesignPointsClosed()
            'l', 'L' -> designAnimal.printDesignPoints()
            'p', 'P' -> {
                endRecordPdf()
                beginRecordPdf()
            }
            'q', 'Q' -> endRecordPdf()
            else -> if (!play) play = true
        }
    }

    private fun getAnimalClasses(): List<Class<*>> {
        val reflections = Reflections("com.github.freekdb.processing.bugfest")
        return reflections[Scanners.SubTypes.of(Organism::class.java).asClass<Organism>()]
            .filter { it != DesignOrganism::class.java }
    }
}
