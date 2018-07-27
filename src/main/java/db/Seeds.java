package db;

import models.*;

import java.util.Arrays;


public class Seeds {

    public static void seedData() {

        DBHelper.deleteAll(DinosaurFood.class);
        DBHelper.deleteAll(Park.class);
        DBHelper.deleteAll(Dinosaur.class);
        DBHelper.deleteAll(Paddock.class);
        DBHelper.deleteAll(Visitor.class);

        DinosaurFood plants = new DinosaurFood("Plants");
        DinosaurFood cow = new DinosaurFood("Cow");
        DinosaurFood goat = new DinosaurFood("Goat");
        DBHelper.saveOrUpdate(plants);
        DBHelper.saveOrUpdate(cow);
        DBHelper.saveOrUpdate(goat);

        Paddock paddock1 = new Paddock("Herbivore Cell A", "Herbivores", 4, plants);
        DBHelper.saveOrUpdate(paddock1);

        Paddock paddock2 = new Paddock("Herbivore Cell B","Herbivores", 5, plants);
        DBHelper.saveOrUpdate(paddock2);

        Paddock paddock3 = new Paddock("Herbivore Cell C", "Herbivores", 3, plants);
        DBHelper.saveOrUpdate(paddock3);

        Paddock paddock4 = new Paddock("Carnivore Cell A","Carnivores", 6, cow);
        DBHelper.saveOrUpdate(paddock4);

        Paddock paddock5 = new Paddock("Carnivore Cell B","Carnivores", 2, goat);
        DBHelper.saveOrUpdate(paddock5);

        Paddock paddock6 = new Paddock("Carnivore Cell C","Carnivores", 7, goat);
        DBHelper.saveOrUpdate(paddock6);

        Paddock paddock7 = new Paddock("Carnivore Cell D","Carnivores", 3, cow);
        DBHelper.saveOrUpdate(paddock7);


        Dinosaur dinosaur1 = new Dinosaur(paddock1, "Stegosaurus","Herbivores",1500,"Green");
        DBHelper.saveOrUpdate(dinosaur1);

        Dinosaur dinosaur2 = new Dinosaur(paddock2,"Brachiosaurus","Herbivores", 600,"Red");
        DBHelper.saveOrUpdate(dinosaur2);

        Dinosaur dinosaur3 = new Dinosaur( paddock3,"Diplodocus","Herbivores", 200,"Purple");
        dinosaur3.setHealthValue(40);
        DBHelper.saveOrUpdate(dinosaur3);

        Dinosaur dinosaur4 = new Dinosaur(paddock4,"Triceratops","Carnivores", 900,"Red");
        DBHelper.saveOrUpdate(dinosaur4);

        Dinosaur dinosaur5 = new Dinosaur(paddock4,"Tyrannosaurus Rex","Carnivores", 1500,"Grey");
        DBHelper.saveOrUpdate(dinosaur5);


        Dinosaur dinosaur6 = new Dinosaur(paddock5,"Velociraptor","Carnivores", 300,"Green");
        DBHelper.saveOrUpdate(dinosaur6);


        Dinosaur dinosaur7 = new Dinosaur(paddock6,"Allosaurus","Carnivores", 500,"Red");
        DBHelper.saveOrUpdate(dinosaur7);


        Park park = new Park("Dino World",5000,250);
        DBHelper.saveOrUpdate(park);

        Visitor visitor1 = new Visitor("Steven Bonner",300,27,182);
        DBHelper.saveOrUpdate(visitor1);

        Visitor visitor2 = new Visitor("Derek Leach", 500, 34,190);
        DBHelper.saveOrUpdate(visitor2);

        Visitor visitor3 = new Visitor("Adri Florence",1,90,250);
        DBHelper.saveOrUpdate(visitor3);

        DBPark.addDinosaurToPark(dinosaur1, park);

        DBPaddock.addDinosaurToPaddock(dinosaur2, paddock1);

        DBVisitor.addVisitorToPark(visitor1, park);

        DBPaddock.removeDinosaurFromPaddock(dinosaur2, paddock1);


    }
}