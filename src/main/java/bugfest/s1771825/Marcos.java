package bugfest.s1771825;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1771825
public class Marcos extends PdfRecorder {
    private int shape = 0;

    public Marcos() {
        super(Marcos.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Marcos.class);
    }

    @Override
    public void settings() {
//         fullScreen();
        size(2000, 1600);
    }

    @Override
    public void setup() {
        frameRate(1);

        beginRecordPdf();
    }

    @Override
    public void draw() {
        background(255);

        for (int i = 0; i < height; i = i + 10) {
            for (int x = 0; x < width; x = x + 10) {
                fill(0, 0, random(200, 200));

                if (shape == 0) {
                    stroke(0, 0, 200);
                    line(x, i, x, i);
                }
                if (shape == 1) {
                    ellipse(x, i, random(10, 20), 10);
                }
                if (shape == 2) {
                    ellipse(x, i, random(1, 20), random(1, 20));
                }
            }
        }

        // println(shape);
    }

    @Override
    public void mousePressed() {
        shape = shape + 1;
        //background(240, 0, 0);
        if (shape == 3) {
            shape = 0;
        }
    }

    @Override
    public void keyPressed() {
        if (key == 'p') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
