package bugfest.s1752224;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

public class Sercan extends PdfRecorder {
    public Sercan() {
        super(Sercan.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Sercan.class);
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
        background(255);
        drawBug(100);
        drawBug(random(190, 200));
        drawBug(300);

        endRecordPdf();
    }

    private void drawBug(float i) {
        float v_x = i;
        int v_y = 200;
        int v_w = 80;
        int v_h = 100;
        float v_x_head = v_x;
        float v_y_head = v_y - (v_h * 0.8f);
        float v_w_head = v_w * 0.6f;
        float v_x_leg_left = v_x - (v_w / 2f);
        float v_x_leg_right = v_x + (v_w / 2f);
        float v_y_leg_up = v_y - v_h;
        float v_y_leg_down = v_y + v_h;

        noFill();
        arc(v_x_leg_left, v_y_leg_up, 60, 60, HALF_PI, PI); // leg1
        //arc(v_x_leg_right, v_y_leg_up, 60, 60, HALF_PI, PI); // leg2
        arc(v_x_leg_left, v_y_leg_down, 60, 60, HALF_PI, PI); // leg3
        //leg4 = arc(v_x_leg_right, v_y_leg_down, 60, 60, HALF_PI, PI); // leg4

        ellipseMode(RADIUS); // Inner white ellipse
        fill(255);
        ellipse(v_x, v_y, v_w, v_h); // Outer white ellipse

        fill(random(255), random(255), random(255));
        ellipse(v_x_head, v_y_head, v_w_head, 40);
    }
}
