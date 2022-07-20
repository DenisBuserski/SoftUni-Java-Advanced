package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Exercises.Raw_Data_04;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyres tyres;

//    public Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Car() {
//        this.engine = new ArrayList<>();
//        this.cargo = new ArrayList<>();
//        this.tyres = new ArrayList<>();
//    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
