package ObjectSpawner;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;

public class MovingObject {

    private static final int DEFAULT_RADIUS = 15;
    private static final Color DEFAULT_COLOR = new Color(30,30,30);
    private static final int MAX_SPEED = 3;

    private Circle shape;
    private int speed;
    private ObjectListener listener;

    public MovingObject(int x, int y, ObjectListener listener) {
        shape  = new Circle(x,y,DEFAULT_RADIUS, DEFAULT_COLOR);
        speed = 1 + (int) (Math.random() * MAX_SPEED);
        this.listener = listener;
    }

    public void draw() {
        shape.draw();
    }

    public void update() {
        shape.move(speed, speed);
        if(shape.getXPos() < 0 || shape.getXPos() > SpawnerApp.CANVAS_WIDTH || shape.getYPos() < 0 || shape.getYPos() > SpawnerApp.CANVAS_HEIGHT) {
            listener.onObjectLeftScreen(this);
        }
    }

}
