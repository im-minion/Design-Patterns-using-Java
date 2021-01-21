/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */

package structural.decorator;

/*
* The decorator design pattern is used to modify the functionality of an object at runtime.
* At the same time, other instances of the same class will not be affected by this,
* so individual object gets the modified behavior.
*
* The decorator design pattern is one of the structural design patterns (such as Adapter Pattern, Bridge Pattern, Composite Pattern)
* and uses abstract classes or interface with the composition to implement.
* */
public class DecoratorPattern {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}

// interface or abstract class defining the methods
interface Car {
    void assemble();
}

//  The basic implementation of the component interface
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}

// Decorator class implements the component interface
// and it has a HAS-A relationship with the component interface.
// The component variable should be accessible to the child decorator classes,
// so we will make this variable protected
class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}

// Extending the base decorator functionality and modifying the component behavior accordingly
class SportsCar extends CarDecorator {
    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}

class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}