/*
 * Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.
 */

package creational.singleton;

import java.io.*;

/*
 * Singleton Pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java virtual machine.
 * It seems to be a very simple design pattern but when it comes to implementation, it comes with a lot of implementation concerns.
 * The implementation of the Singleton pattern has always been a controversial topic among developers
 */

public class SingletonPattern {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        /*01. Eager Initialization Approach*/
        EagerInitializedSingleton.getInstance();

        /*02. Static Block Initialization*/
        StaticBlockSingleton.getInstance();

        /*03. Lazy Initialization*/
        LazyInitialization.getInstance();

        /*04. ThreadSafe Initialization*/
        ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton2.getInstance();

        /*05. Bill Pugh*/
        BillPughSingleton.getInstance();

        /*06. Serialization */
        SerializedSingleton.getInstance();
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
    }

}

/*
 * 01. Eager Initialization
 * - Creates a obj at time of class loading means obj gets created even though not used.
 * - Don't provide exception handling.
 * - Should be used when we don't need any other resources in singleton class.
 * */
class EagerInitializedSingleton {

    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
}

/*
 * 02. Static Block Initialization
 * - similar to eager initialization, just provides an exceptional handling
 * */
class StaticBlockSingleton {
    private static StaticBlockSingleton instance;

    // private constructor to avoid creation of object
    private StaticBlockSingleton() {
    }

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
//            handle e
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

}

/*
 * 03. Lazy Initialization
 * - Creates obj when getInstance() called
 * - This is not thread safe as of now
 * */
class LazyInitialization {
    private static LazyInitialization instance;

    // private constructor to avoid creation of object
    private LazyInitialization() {
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}

/*
 * 04. Thread Safe
 * Extension to the Lazy Loading
 * */
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    // private constructor to avoid creation of object
    private ThreadSafeSingleton() {
    }

    // making getInstance() method synchronised
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

//Above works well but has a performance issue due to method level synchronization
// below approach is 2nd way with synchronized block.
class ThreadSafeSingleton2 {
    private static ThreadSafeSingleton2 instance;

    // private constructor to avoid creation of object
    private ThreadSafeSingleton2() {
    }

    // making getInstance() method synchronised
    public static ThreadSafeSingleton2 getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton2.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton2();
                }
            }
        }
        return instance;
    }
}

/*
 * 05.BillPughSingleton
 * Bill Pugh came up with a different approach to create the Singleton class using an inner static helper class
 * private inner static class that contains the instance of the singleton class. When the singleton class is loaded,
 * SingletonHelper class is not loaded into memory and only when someone calls the getInstance method,
 * this class gets loaded and creates the Singleton class instance
 * */
class BillPughSingleton { //static inner class named 'SingletonHelper'
    // private constructor to avoid creation of object
    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

/*
 * Remember Java Reflection can break the singleton by making the constructors accessible via reflection APIs
 * To overcome this situation Enum can be used to make a singleton class which is unbreakable by reflection.
 * But Enum way doesn't allow LAZY initialization as ENUM executes once at the time of inz
 */

/*
 * 06. SerializedSingleton
 * - Doing Serialization and Deserialization on the singleton class may break the functionality of Singleton
 * - When Singleton class implements Serializable interface we need to add method readResolve().
 * */

class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -7604766932017737115L;

    // private constructor to avoid creation of object
    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    // Adding this method makes Singleton class's Serialization and Deserialization correct.
    protected Object readResolve() {
        return getInstance();
    }
}