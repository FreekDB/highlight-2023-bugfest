package bugfest.s1769101;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;
import processing.core.PImage;

// https://openprocessing.org/sketch/1769101
public class Michele2 extends PdfRecorder {
    private PImage img;
    private PImage img2;
    private int pos = 0;

    public Michele2() {
        super(Michele2.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Michele2.class);
    }

    @Override
    public void settings() {
        size(1262 * 5, 2288);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        frameRate(2);
        img = loadImage("images/Tulix_Color.png"); // Load the image
        img2 = loadImage("images/Tulix_Greyscale.png"); // Load the image
    }

    @Override
    public void draw() {
        // Displays the image at its actual size at point (0,0)
        background(70);
        image(img, 0, 0, 1262, 2288);
        image(img2, 1263, 0, 1262, 2288);
        image(img, 2526, 0, 1262, 2288);
        image(img2, 3789, 0, 1262, 2288);
        image(img, 5052, 0, 1262, 2288);

        textFont(createFont("Georgia", 700));
        textSize(700);
        fill(255, 255, 255);
        //text('Tulipa gesneriana', 300, 600);
        String palabra = "Tulipa gesneriana";
        String substringText = (pos + 1 <= palabra.length()) ? palabra.substring(0, pos + 1) : palabra;
        text(substringText, 300, 1005);

        println(substringText);

        pos++;

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
