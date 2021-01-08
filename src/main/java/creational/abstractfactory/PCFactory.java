package creational.abstractfactory;

import creational.factory.Machine;
import creational.factory.PC;

public class PCFactory implements MachineAbstractFactory{

    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Machine createMachine() {
        return new PC(ram,hdd, cpu);
    }
}
