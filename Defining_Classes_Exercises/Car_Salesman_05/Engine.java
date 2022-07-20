package Defining_Classes_Exercises.Car_Salesman_05;

public class Engine {
    private String engineModel;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, String power, String efficiency, String displacement) {
        this.engineModel = engineModel;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement = displacement;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }
    
}
