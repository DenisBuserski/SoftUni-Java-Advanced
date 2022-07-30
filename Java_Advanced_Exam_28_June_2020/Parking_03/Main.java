package Java_Advanced_Exam_28_June_2020.Parking_03;

public class Main {
    public static void main(String[] args) {

        // Initialize the repository
        Parking parking = new Parking("Underground parking garage", 5);

        // Initialize entity
        Car volvo = new Car("Volvo", "XC70", 2010);

        // Print Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car
        System.out.println(volvo); // Volvo XC70 (2010)

        // Add Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car
        parking.add(volvo);

        // Remove Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car
        System.out.println(parking.remove("Volvo", "XC90")); // false
        System.out.println(parking.remove("Volvo", "XC70")); // true

        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("Audi", "S4", 2005);

        parking.add(peugeot);
        parking.add(audi);

        // Get Latest Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car
        Car latestCar = parking.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)

        // Get Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car
        Car audiS4 = parking.getCar("Audi", "S4");
        System.out.println(audiS4); // Audi S4 (2005)

        // Count
        System.out.println(parking.getCount()); // 2

        // Get Statistics
        System.out.println(parking.getStatistics());
        // The cars are parked in Underground parking garage:
        // Peugeot 307 (2011)
        // Audi S4 (2005)
    }
}
