public class C_LiskovSubstitution {
}

/*3. Liskov Substitution   - if class A is a subtype of class B, then we should be able to replace B with A without disrupting the behavior of our program.
 */

/*
we define a simple Car interface with a couple of methods that all cars should be able to fulfill
*/
interface Car {

    void turnOnEngine();

    void accelerate();
}

class Engine {
    public void on() {
    }

    public void powerOn(int z) {
    }
}

/* Implement the interface in MotorCar class, now We have an engine that we can turn on, and we can increase the power*/

class MotorCar implements Car {

    private Engine engine;

    //Constructors, getters + setters
    @Override
    public void turnOnEngine() {
        //turn on the engine!
        engine.on();
    }

    @Override
    public void accelerate() {
        //move forward!
        engine.powerOn(1000);
    }
}

/*Now we need to make an Electric Car*/
class ElectricCar implements Car {
    @Override
    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    @Override
    public void accelerate() {
        //this acceleration is crazy!
    }
}
/*Here we have failed with the current design as the Electric car is not having an engine.
By throwing a car without an engine into the mix, we are inherently changing the behavior of our program.
This is a blatant violation of Liskov substitution and is a bit harder to fix than our previous 2 principles.
One possible solution would be to rework our model into interfaces that take into account the engine-less state of our Car.*/


