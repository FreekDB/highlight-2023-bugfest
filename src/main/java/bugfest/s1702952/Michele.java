package bugfest.s1702952;

import bugfest.utilities.PdfRecorder;
import processing.core.PApplet;
import processing.core.PImage;

// https://openprocessing.org/sketch/1702952
public class Michele extends PdfRecorder {
    public Michele() {
        super(Michele.class.getName());
    }

    public static void main(String[] arguments) {
        PApplet.main(Michele.class);
    }

    private PImage img;
    private PImage img2;

    @Override
    public void settings() {
        size(1262 * 3, 2288);
    }

    @Override
    public void setup() {
        beginRecordPdf();

        img = loadImage("Tulix_Color.png");
        img2 = loadImage("Tulix_Greyscale.png");
    }

    @Override
    public void draw() {
        // Displays the image at its actual size at point (0,0)
        image(img, 0, 0, 1262, 2288);
        image(img2, 1263, 0, 1262, 2288);
        image(img, 2526, 0, 1262, 2288);


        image(img2, 3789, 0, 1262, 2288);
        image(img, 5052, 0, 1262, 2288);

        textSize(700);
        fill(255, 255, 255);
        text("Tulipa gesneriana", 300, 600);

        endRecordPdf();
    }
}
