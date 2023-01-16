package bugfest.s1703158;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1703158
public class Dimitar extends PdfRecorder {
    public Dimitar() {
        super(Dimitar.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Dimitar.class);
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
        arc(270, 200, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");
        arc(270, 230, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");
        arc(270, 260, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");
        arc(270, 290, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");
        arc(270, 320, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");
        arc(270, 350, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");
        arc(270, 380, 80, 80, 0, PI + QUARTER_PI, CHORD);
        describe("white open arc with black outline with top right missing");


        rect(300, 200, 20, 200, 20);
        describe("white rect with black outline and round edges in mid-right of canvas");

        endRecordPdf();
    }
    
    private void describe(String line) {
        println(line);
    }
}
