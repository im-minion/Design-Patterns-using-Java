/*
 * Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.
 */
package creational.abstractfactory;

/*
* Abstract Factory pattern is similar to Factory pattern and it’s a factory of factories.
* In Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class
* and then an Abstract Factory class that will return the sub-class based on the input factory class.
* */
import creational.factory.Machine;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        PCFactory p = new PCFactory("2GB", "500GB", "2.4GHz");
        ServerFactory s = new ServerFactory("2GB", "500GB", "2.4GHz");

        Machine pcMachine = MachineFactory.getMachine(p);
        Machine serverMachine = MachineFactory.getMachine(s);

        System.out.println(pcMachine.toString());
        System.out.println(serverMachine.toString());
    }
}
