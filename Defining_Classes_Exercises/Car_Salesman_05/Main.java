package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Exercises.Car_Salesman_05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carData = new LinkedList<>();
        Map<String, Engine> engineData = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] engineInput = scanner.nextLine().split("\\s+");
            String engineModel = engineInput[0];
            String enginePower = engineInput[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineInput.length == 4) {
                displacement = engineInput[2];
                efficiency = engineInput[3];
            } else if (engineInput.length == 3) {
                if (!Character.isDigit(engineInput[2].charAt(0))) {
                    efficiency = engineInput[2];
                } else {
                    displacement = engineInput[2];
                }
            }

            Engine engine = new Engine(engineModel, enginePower, efficiency, displacement);
            engineData.put(engineModel, engine);


        }

        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String[] carInput = scanner.nextLine().split("\\s+");
            String carModel = carInput[0];
            String engineModel1 = carInput[1];
            String carWeight = "n/a";
            String color = "n/a";

            if (carInput.length == 4) {
                carWeight = carInput[2];
                color = carInput[3];
            } else if (carInput.length == 3) {

                if (!Character.isDigit(carInput[2].charAt(0))) {
                    color = carInput[2];
                } else {
                    carWeight = carInput[2];
                }
            }
            Car car = new Car(carModel, engineData.get(engineModel1), carWeight, color);

            if (!carData.contains(carModel)) {
                carData.add(car);
            }


        }
        for (int i = 0; i < carData.size(); i++) {

        //Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car car = carData.get(i);

            System.out.println(carData.get(i).getCarModel() + ":");
            System.out.println(carData.get(i).getEngine().getEngineModel() + ":");
            System.out.println("Power: " + carData.get(i).getEngine().getPower());
            System.out.println("Displacement: " + carData.get(i).getEngine().getDisplacement());
            System.out.println("Efficiency: " + carData.get(i).getEngine().getEfficiency());
            System.out.println("Weight: " + carData.get(i).getCarWeight());
            System.out.println("Color: " + carData.get(i).getColor());
        }


    }
}
