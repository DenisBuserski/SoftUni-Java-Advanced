package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Lab.Constructors_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();


        while (n-- > 0) {
            String [] tokens = scanner.nextLine().split("\\s+");
            Car car;
            if (tokens.length == 1) {
                car = new Car(tokens[0]);
            } else {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }


            cars.add(car);
        }

        cars.forEach(System.out::println);



    }
}
