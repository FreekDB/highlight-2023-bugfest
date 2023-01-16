package bugfest.s1703162;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1703162
public class Alyssa extends PdfRecorder {
    public Alyssa() {
        super(Alyssa.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Alyssa.class);
    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        beginRecordPdf();

        background(100);
    }

    @Override
    public void draw() {
        stroke(random(60), random(60, 100), random(100, 200));
        strokeWeight(50);
        line(100, 150, 400, 100);
        line(400, 100, 500, 200);
        line(100, 150, 325, 325);
        line(325, 325, 450, 330);

        line(325, 400, 425, 328);

        line(600, 200, 700, 100);
        line(700, 100, 1000, 150);
        line(775, 325, 1000, 150);
        line(650, 330, 775, 325);

        nextPagePdf();
    }

    @Override
    public void keyPressed() {
        if (key == 'q') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
