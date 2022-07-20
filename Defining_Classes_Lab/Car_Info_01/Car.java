package Defining_Classes_Lab.Car_Info_01;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String token) {
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

    public boolean equals(Car other) {
        return this.brand.equals(other.brand)
                && this.model.equals(other.model)
                && this.horsePower == other.horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
    
}
