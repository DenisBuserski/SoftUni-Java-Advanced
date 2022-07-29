package Java_Advanced_Exam_20_February_2021.Car_Dealership_03;

public class Main {
    public static void main(String[] args) {

        Dealership dealership = new Dealership("Autofest", 5); // Initialize the repository

        Car volvo = new Car("Volvo", "XC70", 2010); // Initialize entity

        // Print Car
        System.out.println(volvo); // Volvo XC70 (2010) 

        dealership.add(volvo); // Add Car

        // Remove Car
        System.out.println(dealership.buy("Volvo", "XC90")); // false
        System.out.println(dealership.buy("Volvo", "XC70")); // true

        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("Audi", "S4", 2005);

        dealership.add(peugeot);
        dealership.add(audi);

        Car latestCar = dealership.getLatestCar(); // Get Latest Car
        System.out.println(latestCar); // Peugeot 307 (2011)

        Car audiS4 = dealership.getCar("Audi", "S4"); // Get Car
        System.out.println(audiS4); // Audi S4 (2005)

        // Count
        System.out.println(dealership.getCount()); // 2

        System.out.println(dealership.getStatistics()); // Get Statistics
        // The cars are in a car dealership Autofest:
        // Peugeot 307 (2011)
        // Audi S4 (2005)
    }
}
