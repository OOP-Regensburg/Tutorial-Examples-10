package ObjectSpawner;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

/**
 * In dieser Demo wird die Verwendung der ArrayList demonstriert. Mithilfe der Maus können Nutzer und Nutzerinnen Kreis
 * auf der Zeichenfläche erzeugen, die sich in eine zufällige Richtung bewegen. Alle Objekte werden in einer Liste
 * gespeichert und automatisch entfernt, wenn sie den sichtbaren Bereich der Anwendung verlassen. Die aktuelle Anzahl
 * der Objekte wird über ein Label dargestellt.
 */

public class SpawnerApp extends GraphicsApp {

    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
    }
}
