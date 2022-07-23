package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Generics_Lab.Generics_Lab_List_Utilities_04;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = List.of(13, 42, 73, 69, - 66);

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));



    }
}
