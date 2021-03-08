public class B_OpenClosed {
}


/*
2. Open/Closed - classes should be open for extension, but closed for modification.
               - we stop ourselves from modifying existing code and causing potential new bugs in an otherwise happy application.
               - one exception to the rule is when fixing bugs in existing code.
*/

/*
As part of a new project, imagine we've implemented a Guitar class.
It's fully fledged and even has a volume knob:
*/
class Guitar {

    private String make;
    private String model;
    private int volume;

    //Constructors, getters & setters
}

/*
we decide the Guitar is a little bit boring and could do with an awesome flame pattern to make it look a bit more ‘rock and roll'.
So instead of modifying the existing Guitar class create new class, because who know what errors can it cause.
This solution stick to the open-closed principle and simply extend our Guitar class:
 */
class SuperCoolGuitarWithFlames extends Guitar {
    private String flameColor;
    //constructor, getters + setters
}