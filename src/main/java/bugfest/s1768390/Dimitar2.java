package bugfest.s1768390;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1768390
public class Dimitar2 extends PdfRecorder {
    public Dimitar2() {
        super(Dimitar2.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Dimitar2.class);
    }

    @Override
    public void settings() {
        size(1000, 1000);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        background(255);

        strokeWeight(random(6));
        fill (random(115,255),random(115,255), random(115,255));
        triangle(400,300,100,200,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(200,300,100,400,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(200,450,100,600,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(200,600,100,800,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(400,750,100,900,500,500) ;

        noFill();

        //other side

        fill (random(115,255),random(115,255), random(115,255));
        triangle(600,300,900,200,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(800,300,900,400,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(800,450,900,600,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(800,600,900,800,500,500) ;

        noFill();

        fill (random(115,255),random(115,255), random(115,255));
        triangle(600,750,900,900,500,500) ;

        noFill();

        line(450,200,500,300);
        line(550,200,500,300);

        fill(0);
        ellipse(500,500,70,400);

        endRecordPdf();
    }
}
