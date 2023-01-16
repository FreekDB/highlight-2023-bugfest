package bugfest.s1752166;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1752166
public class Nail extends PdfRecorder {
    public Nail() {
        super(Nail.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Nail.class);
    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        beginRecordPdf();
    }

    @Override
    public void draw() {
        // int si = 20;

        for (int k = 0; k < 1; k++) {
            float a = random(2000);
/*
            // float b = random(2000);
            // float c = random(255);
            // float d = random(255);
*/
            float r = random(255);
            float g = random(255);
            float b = random(255);
            translate(a, b);
            noStroke();

            for (int i = 0; i < 10; i++) {
                fill(r, g, b);
                ellipse(0, 30, 20, 80);
                rotate(PI / 5);
            }
        }

        rect(0, 70, 20, 80);
    }

    @Override
    public void keyPressed() {
        if (key == 'p') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
