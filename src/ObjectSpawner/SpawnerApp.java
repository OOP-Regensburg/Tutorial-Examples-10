package ObjectSpawner;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.graphics.Label;

import java.util.ArrayList;

/**
 * In dieser Demo wird die Verwendung der ArrayList demonstriert. Mithilfe der Maus können Nutzer und Nutzerinnen Kreis
 * auf der Zeichenfläche erzeugen, die sich in eine zufällige Richtung bewegen. Alle Objekte werden in einer Liste
 * gespeichert und automatisch entfernt, wenn sie den sichtbaren Bereich der Anwendung verlassen. Die aktuelle Anzahl
 * der Objekte wird über ein Label dargestellt.
 */

public class SpawnerApp extends GraphicsApp implements ObjectListener {

    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 500;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;

    private ArrayList<MovingObject> objects;
    private ArrayList<MovingObject> removableObjects;
    private Label currentObjectsIndicator;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        initObjects();
        initLabel();
    }
    
    private void initObjects() {
        objects = new ArrayList<MovingObject>();
        removableObjects = new ArrayList<MovingObject>();
    }
    
    private void initLabel() {
        currentObjectsIndicator = new Label(25,25,"Current objects: 0");
        currentObjectsIndicator.setFont("Monospaced");
        currentObjectsIndicator.setColor(Colors.GREY);
        currentObjectsIndicator.setFontSize(12);
        
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
        updateObjects();
        drawObjects();
        drawLabel();
    }

    private void updateObjects() {
        for(MovingObject object: objects) {
            object.update();
        }
        if(removableObjects.size() > 0) {
            for(MovingObject object: removableObjects) {
                objects.remove(object);
            }
            removableObjects.clear();
        }
    }

    private void drawObjects() {
        for(MovingObject object: objects) {
            object.draw();
        }
    }

    private void drawLabel() {
        currentObjectsIndicator.setText("Current objects: " + objects.size());
        currentObjectsIndicator.draw();
    }

    private void addObject(int x, int y) {
        MovingObject newObject = new MovingObject(x,y, this);
        objects.add(newObject);
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        addObject(event.getXPos(), event.getYPos());
        super.onMousePressed(event);
    }

    @Override
    public void onObjectLeftScreen(MovingObject object) {
        removableObjects.add(object);
    }
}
