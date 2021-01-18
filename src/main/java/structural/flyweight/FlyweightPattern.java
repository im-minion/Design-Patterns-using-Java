/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */

package structural.flyweight;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/*
 * The flyweight design pattern is used when we need to create a lot of Objects of a class.
 * Since every object consumes memory space that can be crucial for low memory devices, such as mobile devices or embedded systems,
 * the flyweight design pattern can be applied to reduce the load on memory by sharing objects.
 * String Pool implementation in java is one of the best examples of Flyweight pattern implementation.
 *
 * Read:
 * https://www.journaldev.com/1562/flyweight-design-pattern-java
 * */
public class FlyweightPattern extends JFrame {

    private final int WIDTH;
    private final int HEIGHT;

    private static final FlyweightShapeFactory.ShapeType[] shapes =
            {
                    FlyweightShapeFactory.ShapeType.LINE,
                    FlyweightShapeFactory.ShapeType.OVAL_FILL,
                    FlyweightShapeFactory.ShapeType.OVAL_NOFILL
            };

    private static final Color[] colors =
            {
                    Color.RED,
                    Color.GREEN,
                    Color.YELLOW
            };

    public FlyweightPattern(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(event -> {
            Graphics g = panel.getGraphics();
            for (int i = 0; i < 20; ++i) {
                Shape shape = FlyweightShapeFactory.getShape(getRandomShape());
                shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
                        getRandomHeight(), getRandomColor());
            }
        });
    }

    private FlyweightShapeFactory.ShapeType getRandomShape() {
        return shapes[(int) (Math.random() * shapes.length)];
    }

    private int getRandomX() {
        return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
        return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
        return (int) (Math.random() * (WIDTH / 10));
    }

    private int getRandomHeight() {
        return (int) (Math.random() * (HEIGHT / 10));
    }

    private Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    public static void main(String[] args) {
        FlyweightPattern drawing = new FlyweightPattern(500, 600);
    }
}

interface Shape {
    void draw(Graphics g, int x, int y, int width, int height, Color color);
}

class Line implements Shape {

    public Line() {
        System.out.println("Creating Line object");
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics line, int x1, int y1, int x2, int y2,
                     Color color) {
        line.setColor(color);
        line.drawLine(x1, y1, x2, y2);
    }

}

class Oval implements Shape {

    //intrinsic property
    private final boolean fill;

    public Oval(boolean f) {
        this.fill = f;
        System.out.println("Creating Oval object with fill=" + f);
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics circle, int x, int y, int width, int height,
                     Color color) {
        circle.setColor(color);
        circle.drawOval(x, y, width, height);
        if (fill) {
            circle.fillOval(x, y, width, height);
        }
    }
}

// FlyWeight Factory
class FlyweightShapeFactory {

    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);

        if (shapeImpl == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shapeImpl = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shapeImpl = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shapeImpl = new Line();
            }
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public enum ShapeType {
        OVAL_FILL, OVAL_NOFILL, LINE;
    }
}