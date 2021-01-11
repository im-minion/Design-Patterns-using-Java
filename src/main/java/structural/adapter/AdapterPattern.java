/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */
package structural.adapter;

/*
 * It’s used to make two unrelated interfaces can work together. The object that joins these unrelated interfaces is called an Adapter.
 * As a real-life example, we can think of a mobile charger as an adapter because the mobile battery needs 3 volts to charge but the normal socket produces either 120V (US) or 240V
 * So the mobile charger works as an adapter between the mobile charging socket and the wall socket
 * */
public class AdapterPattern {
    public static void main(String[] args) {
        SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v120 = getVolt(sockAdapter, 120);
        System.out.println("v3 volts using Object Adapter=" + v3.getVolts());
        System.out.println("v12 volts using Object Adapter=" + v12.getVolts());
        System.out.println("v120 volts using Object Adapter=" + v120.getVolts());


        SocketAdapter sockAdapter2 = new SocketClassAdapterImpl();
        Volt v3_2 = getVolt(sockAdapter, 3);
        Volt v12_2 = getVolt(sockAdapter, 12);
        Volt v120_2 = getVolt(sockAdapter, 120);
        System.out.println("v3 volts using Class Adapter=" + v3_2.getVolts());
        System.out.println("v12 volts using Class Adapter=" + v12_2.getVolts());
        System.out.println("v120 volts using Class Adapter=" + v120_2.getVolts());
    }

    private static Volt getVolt(SocketAdapter sockAdapter, int i) {
        switch (i) {
            case 3:
                return sockAdapter.get3Volt();
            case 12:
                return sockAdapter.get12Volt();
            case 120:
            default:
                return sockAdapter.get120Volt();
        }
    }
}
