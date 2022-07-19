package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Lab.Constructors_02;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand) {
        this(brand, "unknown", -1);
    }
    public Car(String brand, String model) {
        this(brand, model, -1);
    }
    public Car(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }

    public Car (String brand, String model, int horsePower) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }


    public String getInfo() {
        return toString();
    }


    public boolean equals(Car other) {

        return this.brand.equals(other.brand)
                && this.model.equals(other.model)
                && this.horsePower == other.horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsePower());
    }
}

