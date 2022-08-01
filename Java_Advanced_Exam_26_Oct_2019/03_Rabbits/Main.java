package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_26_Oct_2019.Rabbits_03;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository (rabbits.Cage)
        Cage cage = new Cage("Wildness", 20);
        //Initialize entity
        Rabbit rabbit = new Rabbit("Fluffy", "Blanc de Hotot");
        //Print rabbits.Rabbit
        System.out.println(rabbit); // rabbits.Rabbit (Blanc de Hotot): Fluffy

//Add rabbits.Rabbit
        cage.add(rabbit);
        System.out.println(cage.count()); //1
//Remove rabbits.Rabbit
        cage.removeRabbit("rabbits.Rabbit Name"); //false

        Rabbit secondRabbit = new Rabbit("Bunny", "Brazilian");
        Rabbit thirdRabbit = new Rabbit("Jumpy", "Cashmere Lop");
        Rabbit fourthRabbit = new Rabbit("Puffy", "Cashmere Lop");
        Rabbit fifthRabbit = new Rabbit("Marlin", "Brazilian");

//Add Rabbits
//        cage.аdd(secondRabbit);
//        cage.аdd(thirdRabbit);
//        cage.аdd(fourthRabbit);
//        cage.аdd(fifthRabbit);

//Sell rabbits.Rabbit by name
        System.out.println(cage.sellRabbit("Bunny")); //rabbits.Rabbit (Brazilian): Bunny
//Sell rabbits.Rabbit by species
        List<Rabbit> soldSpecies = cage.sellRabbitBySpecies("Cashmere Lop");

        soldSpecies.forEach(f-> {
            System.out.println(f.getName());

        });
        //Jumpy
        //Puffy

        System.out.println(cage.report());
//Rabbits available at Wildness:
//rabbits.Rabbit (Blanc de Hotot): Fluffy
//rabbits.Rabbit (Brazilian): Marlin



    }
}
