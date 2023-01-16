package bugfest.s1768386;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1768386
public class Nadine extends PdfRecorder {
    float beginX = 20.0f; // Initial x-coordinate
    float beginY = 10.0f; // Initial y-coordinate
    float endX = 570.0f; // Final x-coordinate
    float endY = 320.0f; // Final y-coordinate
    float distX; // X-axis distance to move
    float distY; // Y-axis distance to move
    float x = 0.0f; // Current x-coordinate
    float y = 0.0f; // Current y-coordinate
    float step = 0.005f; // Size of each step along the path
    float pct = 0.0f; // Percentage traveled (0.0 to 1.0)

    public Nadine() {
        super(Nadine.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Nadine.class);
    }

    @Override
    public void settings() {
        size(720, 400);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        var r = random(255);
        var g = random(255);
        var b = random(255);
        background(r, g, b);
        noStroke();
        distX = endX - beginX;
        distY = endY - beginY;
    }

    @Override
    public void draw() {
        fill(0, 2);
        pct += step;
        float exponent = random(20);
        if (pct < 1.0) {
            x = beginX + pct * distX;
            y = beginY + pow(pct, exponent) * distY;
        }
        fill(255);
        float radius = 20;
        float point_size = random(20) / 20;
        ellipse(x, y, radius * point_size, radius * point_size);
    }

    @Override
    public void keyPressed() {
        if (key == 'p') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
