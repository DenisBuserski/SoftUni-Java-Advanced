package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_26_Oct_2019.Rabbits_03;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
            if (this.data.size() < getCapacity()){
                this.data.add(rabbit);
            }
    }

    public int count() {
        return data.size();
    }

    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (Rabbit rabbit1 : data) {
            if (rabbit1.getName().equals(name)) {
                rabbit1.setAvailable();
                rabbit = rabbit1;
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species) && rabbit.isAvailable()) {
                rabbits.add(rabbit);
                rabbit.setAvailable();
            }
        }
        return rabbits;
    }

    public String report() {
        StringBuilder fill = new StringBuilder();
        fill.append(String.format("Rabbits available at %s:", this.name))
                .append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            fill.append(rabbit.toString()).append(System.lineSeparator());
        }
        return fill.toString().trim();
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }



}
