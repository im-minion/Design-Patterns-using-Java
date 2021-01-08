package creational.abstractfactory;

import creational.factory.Machine;

public class MachineFactory {
    public static Machine getMachine(MachineAbstractFactory factory) {
        return factory.createMachine();
    }
}
