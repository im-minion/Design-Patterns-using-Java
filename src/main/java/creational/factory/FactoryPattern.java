/*
 * Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.
 */
package creational.factory;

/*
 * The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to return one of the sub-class.
 * This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.
 *
 * In below example we have Machine as a abstract class which can be PC or Server, now here based on the type of the Machine we need to create a object and return that object.
 *
 * Other Example can be Vehicle => which has designedBy() and manufacturedBy() two things but based on type of it viz. Motorcycle, Car, Truck we should get the object.
 */

public class FactoryPattern {
    public static void main(String[] args) {
        Machine machine = MachineFactory.getMachine("pc", "8 GB", "1 TB", "3.2 GHz");
        System.out.println(machine);

        Machine machine2 = MachineFactory.getMachine("server", "32 GB", "500 GB", "4.2 GHz");
        System.out.println(machine2);

    }
}
