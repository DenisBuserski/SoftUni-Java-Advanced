package Defining_Classes_Lab.Car_Info_01;

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
            Car car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
