package bugfest.s1768388;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1768388
public class Dariia extends PdfRecorder {
    private float i = 0f;

    public Dariia() {
        super(Dariia.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Dariia.class);
    }

    @Override
    public void settings() {
        size(1400, 800);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        smooth(10);
    }

    @Override
    public void draw() {
        background(100, 100, 100);
        stroke(2);
        drawBug(i);

        drawBug(i+20);

        drawBug(i-120);
        stroke(40);
        drawBug(i/2);
        stroke(2);
        drawBug(i*2);

        if (i < width && frameCount % 10 == 0) {
            i+=20;
        }
    }

    private void drawBug(float i) {
        rotate(i);
        arc(698, 480, 50, 300, HALF_PI, PI);
        arc(701, 480, 50, 300, 0, HALF_PI);
        rect(670.5f, 445, 60, 30, 20, 20, 20, 20);
        rect(670.5f, 412, 60, 30, 20, 20, 20, 20);
        quad(666, 380, 686, 409, 714.5f, 409, 734.5f, 380);
        arc(700, 376, 50, 50, PI, TWO_PI);
    }

    @Override
    public void keyPressed() {
        if (key == 'p') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
