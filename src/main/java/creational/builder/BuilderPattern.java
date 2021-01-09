package creational.builder;

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

    @Override
    public String toString() {
        return "Machine{" +
                "RAM='" + RAM + '\'' +
                ", HDD='" + HDD + '\'' +
                ", GPU='" + GPU + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                '}';
    }

    private Machine(MachineBuilder machineBuilder) {
        this.HDD = machineBuilder.HDD;
        this.RAM = machineBuilder.RAM;
        this.GPU = machineBuilder.GPU;
        this.isBluetoothEnabled = machineBuilder.isBluetoothEnabled;
    }

    //Static Builder Class
    public static class MachineBuilder {
        // Required Parameters
        private String RAM;
        private String HDD;

        // Optional Parameter
        private String GPU;
        private boolean isBluetoothEnabled;

        public MachineBuilder(String RAM, String HDD) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public MachineBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public MachineBuilder setBluetooth(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Machine build() {
            return new Machine(this);
        }
    }
}