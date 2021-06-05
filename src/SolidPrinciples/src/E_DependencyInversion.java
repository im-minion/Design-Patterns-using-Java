public class E_DependencyInversion {
}


/*
5. Dependency Inversion  - The principle of Dependency Inversion refers to the decoupling of software modules.
                           This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.
*/

/*We want to buy a computer with Keyboard and monitor.
In the computer class if we instantiate the StandardKeyboard and StandardMonitor like below, all the 3 classes will be tightly coupled.
* */

class StandardKeyboard {

}

class StandardMonitor {

}

class Windows98Machine {

    private final StandardKeyboard keyboard;
    private final StandardMonitor monitor;

    public Windows98Machine() {
        monitor = new StandardMonitor();
        keyboard = new StandardKeyboard();
    }
}

/*Now instead of coupling them tightly other approach is we can introduce and Interface Keyboard and Monitor, so that not only StandardKeyboard but other Keyboards can also be used with your new machine
 * and Same goes with Monitor*/
interface Keyboard {

}

interface Monitor {

}

class StandardKeyboard2 implements Keyboard {

}

class StandardMonitor2 implements Monitor {

}

class FunkyKeyborad implements Keyboard {

}

class Windows98Machine2 {

    private final Keyboard keyboard;
    private final Monitor monitor;

    public Windows98Machine2() {
        monitor = new StandardMonitor2();
        keyboard = new StandardKeyboard2();
        // keyboard = new FunkyKeyborad // this can work too
    }
}
