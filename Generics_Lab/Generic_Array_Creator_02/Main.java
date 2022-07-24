package Generics_Lab.Generic_Array_Creator_02;

public class Main {
    public static void main(String[] args) {

        String[] javas = Array_Creator.<String>create(String.class, 13, "Java");

        Integer[] integers = Array_Creator.<Integer>create(Integer.class, 73, 69);
    }
}
