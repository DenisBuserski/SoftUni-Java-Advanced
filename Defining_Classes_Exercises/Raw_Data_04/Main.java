package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Exercises.Raw_Data_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tyre1Pressure = Double.parseDouble(input[5]);
            int tyre1Age = Integer.parseInt(input[6]);
            double tyre2Pressure = Double.parseDouble(input[7]);
            int tyre2Age = Integer.parseInt(input[8]);
            double tyre3Pressure = Double.parseDouble(input[9]);
            int tyre3Age = Integer.parseInt(input[10]);
            double tyre4Pressure = Double.parseDouble(input[11]);
            int tyre4Age = Integer.parseInt(input[12]);

            if (!cars.containsKey(model)) {
                cars.put(model, new Car());
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            cars.get(model).setEngine(engine);

            Cargo cargo = new Cargo(cargoWeight, cargoType);
            cars.get(model).setCargo(cargo);

            Tyres tyres = new Tyres(tyre1Pressure, tyre1Age,
                    tyre2Pressure, tyre2Age,
                    tyre3Pressure, tyre3Age,
                    tyre4Pressure, tyre4Age);

            cars.get(model).setTyres(tyres);


        }

        String command = scanner.nextLine();

        for (Map.Entry<String, Car> entry : cars.entrySet()) {

            if (entry.getValue().getCargo().getCargoType().equals(command)) {

                if (command.equals("fragile") &&
                        entry.getValue().getTyres().getTyre1Pressure() < 1 ||
                        entry.getValue().getTyres().getTyre2Pressure() < 1 ||
                        entry.getValue().getTyres().getTyre3Pressure() < 1 ||
                        entry.getValue().getTyres().getTyre4Pressure() < 1) {
                    System.out.println(entry.getKey());
                } else if (command.equals("flamable") &&
                        entry.getValue().getEngine().getEnginePower() > 250) {
                    System.out.println(entry.getKey());
                }

            }

        }






















    }
}
