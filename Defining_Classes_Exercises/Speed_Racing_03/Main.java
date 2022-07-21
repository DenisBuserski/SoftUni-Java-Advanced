package Defining_Classes_Exercises.Speed_Racing_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> carData = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostFor1km = Double.parseDouble(input[2]);

            if (!carData.containsKey(model)) {
                carData.put(model, new Car(model, fuelAmount, fuelCostFor1km, 0));
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String carModel = tokens[1];
            int distanceTraveled = Integer.parseInt(tokens[2]);
            double neededFuel = distanceTraveled * carData.get(carModel).getFuelCostFor1km();

            if (neededFuel <= carData.get(carModel).getFuelAmount()) {
                int traveledDistance = carData.get(carModel).getDistanceTraveled() + distanceTraveled;
                double fuelLeft = carData.get(carModel).getFuelAmount() - neededFuel;
                carData.get(carModel).setDistanceTraveled(traveledDistance);
                carData.get(carModel).setFuelAmount(fuelLeft);
            } else {
                System.out.printf("Insufficient fuel for the drive%n");
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Car> entry : carData.entrySet()) {
            String car = entry.getKey();
            double fuel = entry.getValue().getFuelAmount();
            int distance = entry.getValue().getDistanceTraveled();

            System.out.printf("%s %.2f %d%n", car, fuel, distance);
        }

    }
}
