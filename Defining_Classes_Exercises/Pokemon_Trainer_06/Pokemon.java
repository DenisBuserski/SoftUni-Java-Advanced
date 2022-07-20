package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Exercises.Pokemon_Trainer_06;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }


    public String getElement() {
        return element;
    }

    public void lowerHealth() {
        this.health -= 10;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
