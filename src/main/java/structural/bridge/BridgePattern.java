/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */

package structural.bridge;

/*
 *  When we have interface hierarchies in both interfaces as well as implementations,
 * then bridge design pattern is used to decouple the interfaces from implementation
 * and hiding the implementation details from the client programs.
 *
 * Decouple an abstraction from its implementation so that the two can vary independently
 *
 * The implementation of bridge design pattern follows the notion to prefer Composition over inheritance.
 *
 * a interface -> Color. This is implemented by Classes of all the colors we have.
 * a abstract Class -> Shape
 *      - this has Composition of a color as constructor parameter
 * Usage ->
 * Triangle Class->extends the abstract class and has a constructor call with super takes Color obj as a parameter
 * etc.
 * */
public class BridgePattern {
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}

interface Color {
    void applyColor();
}

abstract class Shape {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape(Color c) {
        this.color = c;
    }

    abstract public void applyColor();
}

class Triangle extends Shape {
    public Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}

class Pentagon extends Shape {
    public Pentagon(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}

class RedColor implements Color {
    public void applyColor() {
        System.out.println("red.");
    }
}

class GreenColor implements Color {
    public void applyColor() {
        System.out.println("green.");
    }
}