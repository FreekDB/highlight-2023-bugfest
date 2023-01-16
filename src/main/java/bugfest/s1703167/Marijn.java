package bugfest.s1703167;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1703167
public class Marijn extends PdfRecorder {
    public Marijn() {
        super(Marijn.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Marijn.class);
    }

    private float X = 200;
    private float Y = 400;
    private float angle = 0;

    @SuppressWarnings("FieldCanBeLocal")
    private final int length = 20;
    @SuppressWarnings("FieldCanBeLocal")
    private final int thickness = 20;
    @SuppressWarnings("FieldCanBeLocal")
    private final int distance = 3;
    @SuppressWarnings("FieldCanBeLocal")
    private final float shimmer = 0.5f;

    @SuppressWarnings("FieldCanBeLocal")
    private final int dotOneX = 5;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotOneY = 10;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotTwoX = -5;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotTwoY = 5;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotThreeX = -2;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotThreeY = -6;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotFourX = 6;
    @SuppressWarnings("FieldCanBeLocal")
    private final int dotFourY = -12;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        beginRecordPdf();

        rectMode(CENTER);
        background(0, 0, 0);
        frameRate(10);
    }

    private float calculateX(float X, float angle, float dotX, float dotY) {
        return X + cos(angle) * dotY - sin(angle) * dotX;
    }

    private float calculateY(float Y, float angle, float dotX, float dotY) {
        return Y + sin(angle) * dotY + cos(angle) * dotX;
    }

    @Override
    public void draw() {
        // Freek: replaced clear by background.
        // clear();
        background(0, 0, 0);

        angle = angle + random(-shimmer, shimmer);
        X = X + cos(angle) * distance;
        Y = Y + sin(angle) * distance;

        float assX = X - cos(angle) * length;
        float headX = X + cos(angle) * length;
        float assY = Y - sin(angle) * length;
        float headY = Y + sin(angle) * length;

        // body
        stroke(166, 41, 8);
        strokeWeight(thickness);
        line(assX, assY, headX, headY);

        // antenna's
        strokeWeight(2);
        line(headX, headY, headX + cos(angle + 0.5f) * 2 * length, headY + sin(angle + 0.5f) * 2 * length);
        line(headX, headY, headX + cos(angle - 0.5f) * 2 * length, headY + sin(angle - 0.5f) * 2 * length);

        // dots
        strokeWeight(0);
        circle(calculateX(X, angle, dotOneX, dotOneY), calculateY(Y, angle, dotOneX, dotOneY), 6);
        circle(calculateX(X, angle, dotTwoX, dotTwoY), calculateY(Y, angle, dotTwoX, dotTwoY), 6);
        circle(calculateX(X, angle, dotThreeX, dotThreeY), calculateY(Y, angle, dotThreeX, dotThreeY), 6);
        circle(calculateX(X, angle, dotFourX, dotFourY), calculateY(Y, angle, dotFourX, dotFourY), 6);

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
