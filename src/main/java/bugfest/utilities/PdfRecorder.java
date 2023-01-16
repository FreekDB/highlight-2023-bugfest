package bugfest.utilities;

import org.jetbrains.annotations.NotNull;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.pdf.PGraphicsPDF;

import java.io.File;

// List of sketches:
// https://docs.google.com/spreadsheets/d/1NorGvUlWZeTHIgFVYR2jS2qYLug_mc20VR-cYle1WxI/edit#gid=0

// Done:
// Kerem     https://openprocessing.org/sketch/1703108
// Marijn    https://openprocessing.org/sketch/1703167
// Alyssa    https://openprocessing.org/sketch/1703162
// Michele   https://openprocessing.org/sketch/1702952
// Dimitar   https://openprocessing.org/sketch/1703158
// Dimitar 2 https://openprocessing.org/sketch/1768390
// Zdenek    https://openprocessing.org/sketch/1703160
// Andrei    https://openprocessing.org/sketch/1703155
// Xander    https://openprocessing.org/sketch/1702950
// Freek     https://openprocessing.org/sketch/1633134  generate PDFs
// Marijn 2  https://openprocessing.org/sketch/1705246

// To do:
// Sercan    https://openprocessing.org/sketch/1752224
// Mihir     https://openprocessing.org/sketch/1768383
// Michele   https://openprocessing.org/sketch/1702952
// Nail      https://openprocessing.org/sketch/1752166
// Nadine    https://openprocessing.org/sketch/1768386
// Muhammad  https://openprocessing.org/sketch/1752175
// Dariia    https://openprocessing.org/sketch/1768388
// Alix      https://openprocessing.org/sketch/1768389
// Herry     https://openprocessing.org/sketch/1752018
// Marcos    https://openprocessing.org/sketch/1768391
// Johan     https://openprocessing.org/sketch/1752176
// Brian     https://openprocessing.org/sketch/1769100
// Marcos    https://openprocessing.org/sketch/1771825
// Shreya    https://openprocessing.org/sketch/1769105
// Sercan    https://openprocessing.org/sketch/1769107
// Peter     https://openprocessing.org/sketch/1769104
// Michele   https://openprocessing.org/sketch/1769101
// Ruben     https://openprocessing.org/sketch/1769085
// Johan     https://openprocessing.org/sketch/1768371
// Yiyun     https://openprocessing.org/sketch/1771986

public class PdfRecorder extends PApplet {
    private final String className;
    private PGraphics pdfRecorder = null;
    private int pdfNumber = 1;

    public PdfRecorder(String className) {
        this.className = className;
    }

    public void beginRecordPdf() {
        pdfRecorder = beginRecord(PDF, getFilepath());
    }

    public void nextPagePdf() {
        if (pdfRecorder instanceof PGraphicsPDF) {
            ((PGraphicsPDF) pdfRecorder).nextPage();
        } else {
            System.out.println("Error creating the next page in the PDF document.");
        }
    }

    public void endRecordPdf() {
        endRecord();
    }

    @NotNull
    private String getFilepath() {
        String filePath;
        String shortClassName = className.substring(className.lastIndexOf('.') + 1);

        do {
            // filePath = "pdfs/bugfest-" + shortClassName + "-" + "%06d".formatted(pdfNumber) + ".pdf";
            filePath = "pdfs/bugfest-" + shortClassName + "-" + pdfNumber + ".pdf";
            pdfNumber++;
        } while (new File(filePath).exists());

        return filePath;
    }
}
