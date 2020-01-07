package ImageFilter;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.events.KeyPressedEvent;
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
        currentImage = new Image(0, 0, IMAGE_PATH);
    }

    private void loadFilteredImage(ImageFilter filter) {
        int[][] pixels = currentImage.getPixelArray();
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                if(filter == ImageFilter.GRAYSCALE) {
                    pixels[y][x] = getGrayscaleValue(pixels[y][x]);
                } else if(filter == ImageFilter.INVERT) {
                    pixels[y][x] = getInvertedValue(pixels[y][x]);
                }
                int rgbValue = pixels[y][x];
                Color currentColor = new Color(rgbValue);
                int grayscaleValue = (currentColor.red() + currentColor.green() + currentColor.blue()) / 3;
                Color grayscaleColor = new Color(grayscaleValue, grayscaleValue, grayscaleValue);
                pixels[y][x] = grayscaleColor.toInt();
            }
        }
        currentImage.setPixelArray(pixels);
    }

    private int getGrayscaleValue(int rgb) {
        Color currentColor = new Color(rgb);
        int grayscaleValue = (currentColor.red() + currentColor.green() + currentColor.blue()) / 3;
        Color grayscaleColor = new Color(grayscaleValue, grayscaleValue, grayscaleValue);
        return grayscaleColor.toInt();
    }

    private int getInvertedValue(int rgb) {
        Color currentColor = new Color(rgb);
        int redValue = 255 - currentColor.red();
        int greenValue = 255 - currentColor.green();
        int blueValue = 255 - currentColor.blue();
        Color invertedColor = new Color(redValue, greenValue, blueValue);
        return invertedColor.toInt();
    }

    @Override
    public void draw() {
        currentImage.draw();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        switch (event.getKeyCode()) {
            case KeyPressedEvent.VK_1:
                loadUntaintedImage();
                break;
            case KeyPressedEvent.VK_2:
                loadFilteredImage(ImageFilter.GRAYSCALE);
                break;
            case KeyPressedEvent.VK_3:
                loadFilteredImage(ImageFilter.INVERT);
                break;
        }
    }
}
