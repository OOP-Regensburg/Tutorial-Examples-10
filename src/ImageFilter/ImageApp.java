package ImageFilter;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.graphics.Image;

/**
 * In dieser Demo werden die grundlegenden Möglichkeiten der pixel-basierten Manipulation von Bildern in der
 * GraphicsApp-Umgebung demonstriert. Die Anwendung zeigt ein Bild an, dessen Darstellung auf Knopfdruck in eine
 * Graustufen-Repräsentation oder eine invertierte Version umgewandelt werden kann.
 */

public class ImageApp extends GraphicsApp {

    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;
    private static final String IMAGE_PATH = "data/bird.png";

    private Image currentImage;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        loadUntaintedImage();
    }

    /**
     * Lädt die originale Version des verwendeten Bildes in die Instanzvariable currentImage;
     */
    private void loadUntaintedImage() {
        currentImage = new Image(0,0, IMAGE_PATH);
    }

    @Override
    public void draw() {
        currentImage.draw();
    }


}
