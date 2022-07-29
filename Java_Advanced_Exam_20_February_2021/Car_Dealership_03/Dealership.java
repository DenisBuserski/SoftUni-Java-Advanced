package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_20_February_2021.Car_Dealership_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }


    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.size() == 0) {
            return null;
        } else {
            return this.data.stream().max(Comparator.comparingInt(Car::getYear)).get();
        }
    }

    public Car getCar(String manufacturer, String model) {
        if (this.data.size() != 0) {
            for (Car car : data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    return car;
                }
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append("The cars are in a car dealership " + this.name + ":").append(System.lineSeparator());
        for (Car car : data) {
            out.append(car).append(System.lineSeparator());
        }

        return out.toString();
    }
}
