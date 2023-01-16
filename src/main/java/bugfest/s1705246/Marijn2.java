package bugfest.s1705246;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1705246
public class Marijn2 extends PdfRecorder {
    public Marijn2() {
        super(Marijn2.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Marijn2.class);
    }

    private final int size = 999;
    @SuppressWarnings("FieldCanBeLocal")
    private final float[] length = new float[size];
    @SuppressWarnings("FieldCanBeLocal")
    private final float[] thickness = new float[size];
    @SuppressWarnings("FieldCanBeLocal")
    private final float[] angle = new float[size];
    private final float[] distance = new float[size];
    @SuppressWarnings("FieldCanBeLocal")
    private final float[] shimmer = new float[size];
/*
    //    private final int[] ndots = new int[size];
    //    private final int[][] dots = new int[size][];
*/
    private final int[] nlegs = new int[size];
    private final float[] legAngle = new float[size];
    private final float[] X = new float[size];
    private final float[] Y = new float[size];
    private final float[] r = new float[size];
    private final float[] g = new float[size];
    private final float[] b = new float[size];
    private int time = 0;

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

        // define 999 random bugs
        for (int i = 0; i < 999; i++) {
            length[i] = random(50);
            thickness[i] = random(25);
            angle[i] = random(2*PI);
            X[i] = (float) (0.5*displayWidth);
            Y[i] = (float) (0.5*displayHeight);
            distance[i] = random(10);
            shimmer[i] = distance[i] / 20 * random(1);
            r[i] = random(255);
            g[i] = random(255);
            b[i] = random(255);
//            ndots[i] = (int) random(10);
//            dots[i] = new int[ndots[i]];
//            for (int j = 0; j < ndots[i]; j++) {
//                dots[i][j] = [random(-0.5*thickness[i]+5,0.5*thickness[i]-5),
//                        random(-length[i]+5,length[i]-5)];
//            }
            nlegs[i] = round(length[i] / 10) + 2;
        }
    }

/*
//    private float calculateX(float X, float angle, float dotX, float dotY) {
//        return X + cos(angle) * dotY - sin(angle) * dotX;
//    }
//
//    private float calculateY(float Y, float angle, float dotX, float dotY) {
//        return Y + sin(angle) * dotY + cos(angle) * dotX;
//    }
*/

    @Override
    public void draw() {
        // Freek: replaced clear by background.
        // clear();
        background(0, 0, 0);

        time = time + 1;

        int n = 10;
        for (int i = 0; i < n + time / 20; i++) {

            // angle[i] = angle[i] + randomGaussian(0, shimmer[i]);
            angle[i] = angle[i] + randomGaussian() * shimmer[i];
            X[i] = X[i] + cos(angle[i]) * distance[i];
            Y[i] = Y[i] + sin(angle[i]) * distance[i];

            float headX = X[i] + cos(angle[i]) * length[i];
            float headY = Y[i] + sin(angle[i]) * length[i];
            float assX = X[i] - cos(angle[i]) * length[i];
            float assY = Y[i] - sin(angle[i]) * length[i];

            // legs
            strokeWeight(thickness[i]/5);
            stroke(r[i]+100, g[i]+100, b[i]+100);
            legAngle[i] = (float) (0.5 * sin(time * distance[i] / 5));
            for (int j = 0; j < nlegs[i]; j++) {
                float legX = assX + (j / (nlegs[i] - 1f)) * (2 * cos(angle[i]) * length[i]);
                float legY = assY + (j / (nlegs[i] - 1f)) * (2 * sin(angle[i]) * length[i]);
                // left
                float legLeftX = legX + cos((float) (angle[i] - 0.5 * PI + legAngle[i])) * thickness[i];
                float legLeftY = legY + sin((float) (angle[i] - 0.5 * PI + legAngle[i])) * thickness[i];
                line(legX, legY, legLeftX, legLeftY);
                // right
                float legRightX = legX + cos((float) (angle[i] + 0.5 * PI - legAngle[i])) * thickness[i];
                float legRightY = legY + sin((float) (angle[i] + 0.5 * PI - legAngle[i])) * thickness[i];
                line(legX, legY, legRightX, legRightY);
                // next leg opposite direction
                legAngle[i] = -legAngle[i];
            }

            // antenna's
            strokeWeight(thickness[i]/10);
            noFill();
            // left
            float antennaCenterLeftX = headX + cos((float) (angle[i] - 0.5 * PI)) * (10 * thickness[i]);
            float antennaCenterLeftY = headY + sin((float) (angle[i] - 0.5 * PI)) * (10 * thickness[i]);
            arc(antennaCenterLeftX, antennaCenterLeftY, 20 * thickness[i], 20 * thickness[i], (float) (angle[i] + (0.5 - length[i]/200) * PI), (float) (angle[i] + 0.5 * PI));
            // right
            float antennaCenterRightX = headX + cos((float) (angle[i] + 0.5 * PI)) * (10 * thickness[i]);
            float antennaCenterRightY = headY + sin((float) (angle[i] + 0.5 * PI)) * (10 * thickness[i]);
            arc(antennaCenterRightX, antennaCenterRightY, 20 * thickness[i], 20 * thickness[i], (float) (angle[i] + 1.5 * PI), (float) (angle[i] + (1.5 + length[i]/200) * PI));

/*
            // 		// eyes
            // 		fill(255);
            // 		Xxx = headX - cos(0.5 - length[i]/200) * 10 * thickness[i] + 10 * thickness[i];
            // 		Yyy = headY + sin(0.5 - length[i]/200) * 10 * thickness[i];
            // 		circle(Xxx, Yyy,thickness[i]);
*/

            // body
            stroke(r[i], g[i], b[i]);
            strokeWeight(thickness[i]);
            line(assX, assY, headX, headY);

/*
            // // dots
            // strokeWeight(0);
            // fill(255);
            // for (let j = 0; j < ndots[i]; j++) {
            // 	circle(calculateX(X[i], angle[i], dots[i][j][0], dots[i][j][1]), calculateY(Y[i], angle[i], dots[i][j][0], dots[i][j][1]), 6);
            // }
*/
        }

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
