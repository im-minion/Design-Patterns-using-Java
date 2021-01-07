package creational.factory;

public abstract class Machine {
    public abstract String getRam();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return String.format("Computer=> RAM : %s, HDD : %s, CPU: %s", this.getRam(), this.getHDD(), this.getCPU());
    }
}
