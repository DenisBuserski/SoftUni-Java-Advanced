package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Iterators_And_Comparators_Lab.Library_02;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        Library library = new Library();

        library.add(bookOne);
        library.add(bookTwo);
        library.add(bookThree);

        for (Book book: library) {
            System.out.println(book.getTitle());
        }
    }

}
