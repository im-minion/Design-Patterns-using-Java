package creational.singleton;
// Creational design patterns provide solution to instantiate a object in the best possible way for specific situations.

// Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java virtual machine.
// It seems to be a very simple design pattern but when it comes to implementation, it comes with a lot of implementation concerns.
// The implementation of the Singleton pattern has always been a controversial topic among developers
public class SingletonPattern {
    public static void main(String[] args) {
        /*01. Eager Initialization Approach*/
        EagerInitializedSingleton.getInstance();

        /*02. Static Block Initialization*/
        StaticBlockSingleton.getInstance();

        /*03. Lazy Initialization*/
        LazyInitialization.getInstance();
    }
}

/*
 * 01. Eager Initialization
 * - Creats a obj at time of class loading means obj gets created even though not used.
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

class LazyInitialization {
    private static LazyInitialization instance;

    public static LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }
}
