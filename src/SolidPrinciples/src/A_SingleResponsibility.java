public class A_SingleResponsibility {
}

/*
1. Single Responsibility - a class should only have one responsibility. (think about aspects like Testing, LowerCoupling, Organization)
Book class has Book properties name,author and text along with book related method like replaceWord.
*/
class Book {

    private String name;
    private String author;
    private String text;

    //constructor, getters and setters

    // methods that directly relate to the book properties
    public String replaceWordInText(String word) {
        return text.replaceAll(word, text);
    }

    public boolean isWordInText(String word) {
        return text.contains(word);
    }

    /*
    now if there is a need to print some Texts to console and you add that method here it breaks the Single responsibility
    below method eg. <Breaks the "S" principle>
        void printTextToConsole(){
            // our code for formatting and printing the text
        }
    */
}

/*
Now inorder to print the Texts to console you should write another class and that class will hold the single responsibility of printing the Texts.
BookPrinter not only printToConsole but it can also printToAnotherMedium.
*/
class BookPrinter {

    // methods for outputting text
    void printTextToConsole(String text) {
        //our code for formatting and printing the text
    }

    void printTextToAnotherMedium(String text) {
        // code for writing to any other location..
    }
}