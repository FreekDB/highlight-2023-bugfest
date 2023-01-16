package bugfest.s1703155;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1703155
public class Andrei extends PdfRecorder {
    public Andrei() {
        super(Andrei.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Andrei.class);
    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        beginRecordPdf();

        background(255, 255, 255);
    }

    @Override
    public void draw() {
        fill(0, 0, 0);
        arc(300, 170, 200, 200, PI, TWO_PI);
        noFill();
        stroke(0, 0, 0);
        arc(410, 250, 100, 100, 80, 75);
        arc(430, 330, 100, 100, 80, 75);
        arc(410, 420, 100, 100, 80, 75);
        arc(200, 450, 100, 150, 10, 30);
        arc(190, 275, 100, 150, 10, 30);
        arc(175, 360, 100, 150, 10, 30);
        fill(173, 60, 44);
        noStroke();
        ellipse(300, 300, 300, 350);
        fill(0, 0, 0);
        ellipse(370, 380, 45, 50);
        fill(0, 0, 0);
        ellipse(230, 380, 45, 50);
        fill(0, 0, 0);
        ellipse(400, 240, 45, 50);
        fill(0, 0, 0);
        ellipse(200, 240, 45, 50);
        fill(0, 0, 0);
        ellipse(300, 180, 45, 50);
        noFill();
        stroke(0, 0, 0);
        arc(200, 105, 80, 80, PI + QUARTER_PI, TWO_PI);
        arc(450, 105, 200, 100, PI, PI + QUARTER_PI);
        fill(0, 0, 0);
        rect(299, 220, 1, 200);
        fill(255, 255, 255);
        noStroke();
        fill(255, 255, 255);
        ellipse(380, 105, 25, 25);
        ellipse(220, 105, 25, 25);
        ellipse(299, 70, 25, 25);
        fill(173, 60, 44);
        ellipse(400, 60, 25, 25);
        ellipse(170, 75, 25, 25);

        endRecordPdf();
    }
}
