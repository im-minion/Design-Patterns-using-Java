package creational.abstractfactory;

import creational.factory.Machine;
import creational.factory.Server;

public class ServerFactory implements MachineAbstractFactory {
    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu) {
        this.ram = ram;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    @Override
    public Machine createMachine() {
        return new Server(ram, hdd, cpu);
    }
}
