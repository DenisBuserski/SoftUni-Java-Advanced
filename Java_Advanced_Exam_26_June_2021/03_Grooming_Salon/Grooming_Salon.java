package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_26_June_2021.Problem_3_Grooming_Salon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this. capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        out.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            out.append(pet.getName() + " " + pet.getOwner()).append(System.lineSeparator());

        }
        return out.toString();
    }
}


