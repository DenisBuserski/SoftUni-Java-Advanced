package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Generics_Lab.Generics_Lab_List_Utilities_04;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        ensureNotEmpty(list);
        return Collections.min(list);
    }

    private static <T extends Comparable<T>> void ensureNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        ensureNotEmpty(list);
        return Collections.max(list);
    }






}
