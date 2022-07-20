package Defining_Classes_Exercises.Car_Salesman_05;

public class Car {
    private String carModel;
    private Engine engine;
    private String carWeight;
    private String color;

    public Car(String carModel, Engine engine, String carWeight, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.carWeight = carWeight;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getCarWeight() {
        return carWeight;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getCarModel() {
        return carModel;
    }

}
