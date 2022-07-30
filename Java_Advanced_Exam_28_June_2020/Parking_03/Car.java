package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03;

public class Car {
    //fields
    private String manufacturer;
    private String model;
    private int year;

    //constructor
    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        //"{manufacturer} {model} ({year})"
        return String.format("%s %s (%d)", getManufacturer(), getModel(), getYear());
    }
}