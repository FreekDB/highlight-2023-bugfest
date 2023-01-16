package bugfest.s1702950;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;

// https://openprocessing.org/sketch/1702950
public class Xander extends PdfRecorder {
    public Xander() {
        super(Xander.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Xander.class);
    }

    private boolean play = true;

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void setup() {
        beginRecordPdf();

        background(100);
        frameRate(5);
    }

    @Override
    public void draw() {
        float r = random(255);
        float g = random(255);
        float b = random(255);

        fill(r, g, b);

        circle(mouseX, mouseY, 20);
        float x = random(2000);
        float y = random(2000);
        if (play) {
            line(0, 0, 500, 500);
            rect(10 + x, 10 + y, 30, 30);
//    rect(j+10,j+10,j+20,j+20);

        } else /*if (!play)*/ {
            for (int i = 0; i < 10; i++) {
                r = random(255);
                g = random(255);
                b = random(255);
                fill(r, g, b);
                //w=random(100);
                //circle(x,y,w);
                circle(x, y, 100 - i * 10);
                circle(x + 100, y, 100 - i * 10);
            }
        }
    }

    @Override
    public void mousePressed() {
        if (mouseButton == LEFT) {
            this.draw();
        }
        else if (mouseButton == RIGHT) {
            this.draw();
        }

        if (!play) {
            play = true;
        }
    }

    @Override
    public void keyPressed() {
        if (key == 's' || key == 'S') {
            play = false;
        }
        else if (key == 'p' || key == 'P') {
            play = true;
        }
        else if (key == 'q') {
            endRecordPdf();
            beginRecordPdf();
        }
    }
}
