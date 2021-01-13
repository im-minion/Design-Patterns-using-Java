/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */

package structural.composite;

/*
 *
 *  Real life example – A diagram is a structure that consists of Objects such as Circle, Lines, Triangle etc.
 * When we fill the drawing with color (say Red), the same color also gets applied to the Objects in the drawing
 * Composite Pattern consists of following objects.
 *
 * Base Component – Base component is the interface for all objects in the composition,
 *                  client program uses base component to work with the objects in the composition.
 *
 * Leaf – Defines the behaviour for the elements in the composition.
 *        It is the building block for the composition and implements base component
 *
 * Composite – It consists of leaf elements and implements the operations in base component.
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}

// Base Component –
interface Shape {
    void draw(String fillColor);
}

// Leaf -
class Triangle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color " + fillColor);
    }
}

// Leaf -
class Circle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color " + fillColor);
    }
}

// Composite -
class Drawing implements Shape {

    //collection of Shapes
    private final List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        for (Shape sh : shapes) {
            sh.draw(fillColor);
        }
    }

    //adding shape to drawing
    public void add(Shape s) {
        this.shapes.add(s);
    }

    //removing shape from drawing
    public void remove(Shape s) {
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear() {
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}