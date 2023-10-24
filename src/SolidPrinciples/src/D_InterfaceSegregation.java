public class D_InterfaceSegregation {
}


/*4. Interface Segregation - larger interfaces should be split into smaller ones. So, we can ensure that implementing classes only need to be concerned about the methods that are of interest to them.
 */

/* You are a zookeeper and you need Wash, Fed and pet the Bear. this actions can be part ot one Interface as like*/
interface BearKeeper {
    void washTheBear();

    void feedTheBear();

    void petTheBear();
}

/*Now as the Bears are dangerous you don't want to wash and feed them, so you are keeping a guy to do this.
 * But with our above interface we have no choice but to do all the activities. So its alway better to keep the interfaces segregated, like below*/

interface BearCleaner {
    void washTheBear();
}

interface BearFeeder {
    void feedTheBear();
}

interface BearPetter {
    void petTheBear();
}

/* Now the one who cares for the bear will implement 'BearCleaner' and 'BearFeeder'
 * And the one who owns/pet them will implement 'BearPetter'*/

class Human implements BearPetter {

    @Override
    public void petTheBear() {

    }
}

class Guy implements BearFeeder, BearCleaner {

    @Override
    public void washTheBear() {

    }

    @Override
    public void feedTheBear() {

    }
}

class OtherGuy implements BearCleaner, BearFeeder, BearPetter {
    @Override
    public void washTheBear() {

    }

    @Override
    public void feedTheBear() {

    }

    @Override
    public void petTheBear() {

    }
}

// with previous impl
class OtherGuy2 implements BearKeeper {

    @Override
    public void washTheBear() {

    }

    @Override
    public void feedTheBear() {

    }

    @Override
    public void petTheBear() {

    }
}