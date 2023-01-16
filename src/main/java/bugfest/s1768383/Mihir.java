package bugfest.s1768383;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1768383
public class Mihir extends PdfRecorder {
    public Mihir() {
        super(Mihir.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Mihir.class);
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
        background(150, 100, 50);

        var r = random(255);
        var b = random(255);
        var g = random(255);

        background(r, b, g);

//        for (int j = 0; j < 20; j++) {
//
//            rotateX(millis() / 500f);
//
//            for (int i = 0; i < 20; i++) {
//
//                rotateY(millis() / 700f);
//                rotateZ(millis() / 700f);
//
//                translate(width / 50f, height / 50f);
//                PVector angleVector = PVector.fromAngle(millis() / 1000f, new PVector(10f * j, 0f));
//                translate(angleVector.x, angleVector.y);
//
//                int c = color("hsb(160, 100%, 50%)");
//                fill(c);
//                triangle(60 + i * 30, 50, 60, 100, 100, 40);
//                let d = color(255, 204, 0);
//                fill(d);
//                triangle(60 + i * 30, 50, 50, 100, 10, 80);
//                colorMode(HSB, 100);
//                let e = color(50, 55, 100);
//                fill(e);
//                triangle(60 + i * 30, 50, 20, 10, 50, 120);
//            }
//        }
//
//        for (let j = 0; j < 10; j++) {
//
//            // rotateX(millis() / 2000);
//            rotateY(millis() / 2050);
//            // square(70, 70, 100);
//            rotateX(millis() / 2050);
//            // circle(70, 70, 50);
//
//
//            for (let i = 0; i < 100; i++) {
//                j = i;
//                rotateY(millis() / 1000);
//                // rotateZ(millis() / 00);
//
//                translate(windowWidth / 50, windowHeight / 50);
//                translate(p5.Vector.fromAngle(millis() / 500, 10 * j));
//
//                let c = color('hsb(160, 100%, 50%)');
//                fill(c);
//                triangle(60 + i * 30, 50, 60, 100, 100 + j, 40);
//                let d = color(255, 204, 0);
//                fill(d);
//                triangle(60 + i * 30, 50, 50, 100, 10 + j, 80);
//                colorMode(HSB, 100);
//                let e = color(50, 55, 100);
//                fill(e);
//                triangle(60 + i * 30, 50, 20, 10, 50 + j, 120);
//            }
//
//            let c = color('hsb(160, 100%, 50%)');
//            fill(c);
//            rect(60 + j * 30, 100 + j, 20, 20);
//            let d = color(255, 204, 0);
//            fill(d);
//            rect(60 + j * 30, 10 + j, 30, 40);
//            colorMode(HSB, 100);
//            let e = color(50, 55, 100);
//            fill(e);
//            rect(60 + j * 30, 50 + j, 60, 80);
//        }
    }
}
