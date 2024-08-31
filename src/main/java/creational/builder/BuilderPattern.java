/*
 * Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.
 */

package creational.builder;

/*
 * Builder pattern solves the issue with a large number of optional parameters and inconsistent state by providing a way to build the object step-by-step
 * and provide a method that will actually return the final Object
 * */
public class BuilderPattern {
    public static void main(String[] args) {
        Machine m = new Machine.MachineBuilder("8GB", "1TB").setGPU("4GB NVDIA").setBluetooth(true).build();
        System.out.println(m);
    }
}

class Machine {
    // Required Parameters
    private String RAM;
    private String HDD;

    // Optional Parameter
    private String GPU;
    private boolean isBluetoothEnabled;

    // private constructor
    private Machine() {
    }

    // actual class constructor that takes the Builder object
    private Machine(final MachineBuilder machineBuilder) {
        this.HDD = machineBuilder.HDD;
        this.RAM = machineBuilder.RAM;
        this.GPU = machineBuilder.GPU;
        this.isBluetoothEnabled = machineBuilder.isBluetoothEnabled;
    }

    public String getRAM() {
        return RAM;
    }

    public String getHDD() {
        return HDD;
    }

    public String getGPU() {
        return GPU;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    //Public Static Builder Class
    public static class MachineBuilder {
        // Required Parameters
        private final String RAM;
        private final String HDD;

        // Optional Parameter
        private String GPU;
        private boolean isBluetoothEnabled;

        // constructor for Required Parameters
        public MachineBuilder(final String RAM, final String HDD) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        // setters for other Optional Parameters
        public MachineBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public MachineBuilder setBluetooth(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // build method which returns actual Object
        protected Machine build() {
            return new Machine(this);
        }
    }

    @Override
    public String toString() {
        return "Machine{" +
                "RAM='" + RAM + '\'' +
                ", HDD='" + HDD + '\'' +
                ", GPU='" + GPU + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }
}