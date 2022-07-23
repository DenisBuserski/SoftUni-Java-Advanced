package Generics_Lab.Generics_Lab_Generic_Scale_03;

public class Main {
    public static void main(String[] args) {

        Scale<String> scale = new Scale<>("a", "z");
        // Scale<Integer> scale = new Scale<>(73, 13);

        System.out.println(scale.getHeavier());
    }
}
