package bugfest.s1769100;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1769100
public class Brian4 extends PdfRecorder {
    public Brian4() {
        super(Brian4.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Brian4.class);
    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        beginRecordPdf();

        background(random(255), random(255), random(255));
        frameRate(1);
    }

    @Override
    public void draw() {
        noLoop();
        translate(500, 500);
        def();
    }

    private void def() {
        fill(50, 50, 50);
        bezier(0, 0, 100, 20, 150, 30, 0, 300);

        fill(50, 50, 50);
        bezier(0, 0, -100, 20, -150, 30, 0, 300);
    }
}
