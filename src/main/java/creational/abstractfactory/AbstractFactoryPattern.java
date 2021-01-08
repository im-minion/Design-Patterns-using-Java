package creational.abstractfactory;

import creational.factory.Machine;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Machine pcMachine = MachineFactory.getMachine(new PCFactory("2GB", "500GB", "2.4GHz"));
        Machine serverMachine = MachineFactory.getMachine(new ServerFactory("2GB", "500GB", "2.4GHz"));

        System.out.println(pcMachine.toString());
        System.out.println(serverMachine.toString());
    }
}
