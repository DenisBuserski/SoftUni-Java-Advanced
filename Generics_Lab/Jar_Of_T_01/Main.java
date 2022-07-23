package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Generics_Lab.Generics_Lab_Jar_Of_T_01;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar  = new Jar<String>();

        jar.add("13");
        jar.add("42");
        jar.add("69");


        System.out.println(jar.remove());
        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
