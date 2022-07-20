package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Exercises.Raw_Data_04;

public class Tyres {

    private double tyre1Pressure;
    private int tyre1Age;
    private double tyre2Pressure;
    private int tyre2Age;
    private double tyre3Pressure;
    private int tyre3Age;
    private double tyre4Pressure;
    private int tyre4Age;


    public Tyres(double tyre1Pressure, int tyre1Age,
                 double tyre2Pressure, int tyre2Age,
                 double tyre3Pressure, int tyre3Age,
                 double tyre4Pressure, int tyre4Age) {
        this.tyre1Pressure = tyre1Pressure;
        this.tyre1Age = tyre1Age;
        this.tyre2Pressure = tyre2Pressure;
        this.tyre2Age = tyre2Age;
        this.tyre3Pressure = tyre3Pressure;
        this.tyre3Age = tyre3Age;
        this.tyre4Pressure = tyre4Pressure;
        this.tyre4Age = tyre4Age;
    }

    public double getTyre1Pressure() {
        return tyre1Pressure;
    }

    public double getTyre2Pressure() {
        return tyre2Pressure;
    }

    public double getTyre3Pressure() {
        return tyre3Pressure;
    }

    public double getTyre4Pressure() {
        return tyre4Pressure;
    }
}
