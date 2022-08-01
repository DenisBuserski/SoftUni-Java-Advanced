package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_26_Oct_2019.Rabbits_03;

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        available = true;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = false;
    }

    @Override
    public String toString() {
        return String.format("rabbits.Rabbit (%s): %s", this.getSpecies(), this.getName());
    }
}
