package bugfest.s1752175;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1752175
public class Muhammad extends PdfRecorder {
    public Muhammad() {
        super(Muhammad.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Muhammad.class);
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
        background(100);
        //circle(mouseX, mouseY, 20);
        noStroke();
        fill(120, 0, 0);
        ellipse(300, 300, 350, 450);
        fill(10, 9, 8);
        arc(300, 500, 150, 150, 0, HALF_PI);
        arc(300, 500, 150, 150, 0, PI);
        fill(0, 48, 73);
        //line(
        quad(300, 500, 300, 20, 169, 63, 30, 76);
        //quad(300, 500, 300, 20, 369, 63, 300, 76);
        quad(300, 500, 300, 20, 369, 63, 500, 76);

        fill(0, 48, 73);
        arc(300, 500, 86, 86, 0, HALF_PI);
        arc(300, 500, 86, 86, 0, PI);
        fill(10, 9, 8);
        for (var i = 0; i <= 10; i++) {
            var x = random(140);
            var y = random(140);

            ellipse(300 + x, 300 + y, 35, 45);
            ellipse(300 - x, 300 - y, 35, 45);
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
