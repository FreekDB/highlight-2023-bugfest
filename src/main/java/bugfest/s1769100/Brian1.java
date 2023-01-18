package bugfest.s1769100;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1769100
public class Brian1 extends PdfRecorder {
    public Brian1() {
        super(Brian1.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Brian1.class);
    }

    @Override
    public void settings() {
        //int s = (int) (min(width, height) * 0.9);
        //size(s, s);
        fullScreen();
        println(width * 0.9);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        background(random(255),random(255),random(255));
        frameRate(1);
    }

    @Override
    public void draw() {
        ellipseMode(CENTER);
        draw_ellipses();
        bezier(85, 200, 100, 100, 90, 90, 15, 80);
    }

    private void draw_ellipses(){
        for (int i = 1; i < 9; i++) {
            ellipse(350+random(300),350+random(300),(60*i),60*i*random(10));
            fill(255*rands(),255*rands(),255*rands(),60);
        }
    }

    private float rands() {
        return random(10)/10;
    }
}
