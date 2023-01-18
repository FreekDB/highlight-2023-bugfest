package bugfest.s1769100;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1769100
public class Brian5 extends PdfRecorder {
    private float x;
    private float y;
    private float rBackground;
    private float gBackground;
    private float bBackground;

    public Brian5() {
        super(Brian5.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Brian5.class);
    }

    @Override
    public void settings() {
        // fullScreen();
        size(2000, 1600);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        rBackground = random(255);
        gBackground = random(255);
        bBackground = random(255);

        background(rBackground, gBackground, bBackground);

        frameRate(1);

        x = width / 2f;
        y = height / 2f;
    }

    @Override
    public void draw() {
        translate(0, -millis() / 100f);
        rotate(PI / 10);
        arcs(x, y);
        y = y - 1;
    }

    private void arcs(float x, float y) {
        // clear();
        background(rBackground, gBackground, bBackground);

        translate(x, y);
        float r = random(255);
        float g = random(255);
        float b = random(255);

        //head
        noStroke();
        fill(0, 0, 0);
        ellipseMode(RADIUS);
        arc(0, -50, 30, 20, -HALF_PI, PI / 16);
        // arc(0, -50, -30, 20, -PI - PI / 16, -HALF_PI);
        arc(0, -50, 30, 20, -PI - PI / 16, -HALF_PI);

        //antenna
        noFill();
        stroke(0);
        strokeWeight(1);
        bezier(5, -49, 20, -100, 80, -190, 100, -200);
        bezier(-5, -49, -20, -100, -80, -190, -100, -200);


        //body
        noStroke();
        fill(r, g, b);
        ellipseMode(RADIUS);

        arc(0, 0, 100, 50, -HALF_PI, 0);
        // arc(0, 0, -100, 50, -PI, -HALF_PI);
        arc(0, 0, 100, 50, -PI, -HALF_PI);
        fill(r - 10, g - 5, b - 2);
        bezier(100, 0, 100, 50, 97, 65, 0, 200);
        bezier(-100, 0, -100, 50, -97, 65, 0, 200);

        beginShape();
        noStroke();
        vertex(0, 0);
        vertex(100, 0);
        vertex(0, 200);
        endShape(CLOSE);
        beginShape();
        noStroke();
        vertex(0, 0);
        vertex(-100, 0);
        vertex(0, 200);
        endShape(CLOSE);

        //legs
        beginShape();
        noFill();
        stroke(0);
        strokeWeight(2);
        vertex(99, 5);
        vertex(120, -20);
        vertex(140, -80);
        endShape();
        beginShape();
        noFill();
        stroke(0);
        strokeWeight(2);
        vertex(99, 25);
        vertex(120, 70);
        vertex(140, 150);
        endShape();
        beginShape();
        noFill();
        stroke(0);
        strokeWeight(2);
        vertex(55, 120);
        vertex(70, 180);
        vertex(50, 300);
        endShape();
        beginShape();
        noFill();
        stroke(0);
        strokeWeight(2);
        vertex(-99, 5);
        vertex(-120, -20);
        vertex(-140, -80);
        endShape();
        beginShape();
        noFill();
        stroke(0);
        strokeWeight(2);
        vertex(-99, 25);
        vertex(-120, 70);
        vertex(-140, 150);
        endShape();
        beginShape();
        noFill();
        stroke(0);
        strokeWeight(2);
        vertex(-55, 120);
        vertex(-70, 180);
        vertex(-50, 300);
        endShape();
    }

    @Override
    public void keyPressed() {
        if (key == 'p') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
