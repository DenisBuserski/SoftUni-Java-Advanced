package Generics_Lab.Generics_Lab_List_Utilities_04;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = List.of(13, 42, 73, 69, - 66);

        System.out.println(List_Utils.getMin(integers));
        System.out.println(List_Utils.getMax(integers));
    }
}
