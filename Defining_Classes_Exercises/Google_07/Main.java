package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Defining_Classes_Exercises.Google_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personData = new HashMap<>();

        while(!input.equals("End")) {
            String [] parameters = input.split("\\s+");
            String name = parameters[0];

            if(!personData.containsKey(name)) {
                personData.put(name, new Person());
            }

            String enteredData = parameters[1];

            switch (enteredData) {
                case "company":
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName, department, salary);

                    personData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    personData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters[2];
                    String parentBirthday = parameters[3];
                    Parent parent = new Parent(parentName, parentBirthday);

                    personData.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Child child = new Child(childName, childBirthday);

                    personData.get(name).getChildren().add(child);
                    break;
                case "car":
                    String carModel = parameters[2];
                    int carSpeed = Integer.parseInt(parameters[3]);
                    Car car = new Car(carModel, carSpeed);

                    personData.get(name).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = personData.get(searchedPerson);
        System.out.println(personalData);
    }
}
