package bugfest.s1703108;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1703108
public class Kerem extends PdfRecorder {
    public Kerem() {
        super(Kerem.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Kerem.class);
    }

    @Override
    public void settings() {
        size(1500, 1500);
    }

    @Override
    public void setup() {
        background(255);

        // Freek: make sure we get only one pdf.
        noLoop();
    }

    @Override
    public void draw() {
        beginRecordPdf();

        fill(255, 227, 36);
        noStroke();

        ellipse(750, 450, 200, 375);
        ellipse(750, 1050, 200, 375);
        ellipse(450, 750, 375, 200);
        ellipse(1050, 750, 375, 200);
        rotate(PI / 4);
        ellipse(1000, 350, 200, 375);

        rotate(-PI / 4);
        fill(189, 84, 15);
        noStroke();
        circle(750, 750, 400);

        fill(168, 77, 16);
        noStroke();
        circle(750, 750, 300);

        fill(111, 51, 11);
        noStroke();
        circle(750, 750, 200);

        endRecordPdf();
    }
}
