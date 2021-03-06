package Iterators_And_Comparators_Lab.ComparableBook_03;

public class Main {
    public static void main(String[] args) {
        
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format("%s is before %s", bookOne.getTitle(), bookTwo.getTitle()));
        }
        if (bookTwo.compareTo(bookThree) < 0) {
            System.out.println(String.format("%s is before %s", bookTwo.getTitle(), bookThree.getTitle()));
        }
        
    }
}
