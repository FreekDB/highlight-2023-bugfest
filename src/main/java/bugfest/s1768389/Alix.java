package bugfest.s1768389;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1768389
public class Alix extends PdfRecorder {
    public Alix() {
        super(Alix.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Alix.class);
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
        background(0, 127, 0);
        fill(0, 196, 0);

        var x_step = 4;
        var a_step = PI / 256;

        for (int k = 0; k < 512; k++) {
            push();
            var x = random(0, width);
            var y = random(0, height);
            translate(x, y);
            rotate(random(0, 2 * PI));
            scale(random(0.16f, 0.64f));
            for (int i = 0; i < 32; i++) {
                push();
                translate(x_step * exp(i / 10f),
                        0 - i * 10f);
                rotate(a_step * i);
                scale(1.0f - i * 0.03f);
                triangle(-100, 100, 100, 100, 0, -100);
                pop();
            }
            pop();
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
