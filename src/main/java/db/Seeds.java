package db;

import models.*;


public class Seeds {

    public static void seedData() {

//        DBHelper.deleteAll(DinosaurFood.class);
        DBHelper.deleteAll(Park.class);
        DBHelper.deleteAll(Dinosaur.class);
        DBHelper.deleteAll(Paddock.class);
        DBHelper.deleteAll(Visitor.class);

        Paddock paddock1 = new Paddock("Tyrannosaurus Cell",4, DinosaurFood.PLANTS);
        DBHelper.saveOrUpdate(paddock1);

        Paddock paddock2 = new Paddock("Velociraptor Cell",5, DinosaurFood.GOAT);
        DBHelper.saveOrUpdate(paddock2);

        Paddock paddock3 = new Paddock("Spinosaurus Cell", 3, DinosaurFood.COW);
        DBHelper.saveOrUpdate(paddock3);

        Paddock paddock4 = new Paddock("Triceratops Cell",6, DinosaurFood.GOAT);
        DBHelper.saveOrUpdate(paddock4);

        Paddock paddock5 = new Paddock("Stegosaurus Cell",2, DinosaurFood.COW);
        DBHelper.saveOrUpdate(paddock5);

        Paddock paddock6 = new Paddock("Brachiosaurus Cell",7, DinosaurFood.PLANTS);
        DBHelper.saveOrUpdate(paddock6);

        Paddock paddock7 = new Paddock("Allosaurus Cell",3, DinosaurFood.COW);
        DBHelper.saveOrUpdate(paddock7);

        Dinosaur dinosaur1 = new Dinosaur(paddock1, "Tyrannosaurus Rex","Carnivores",1500,"Green");
        DBHelper.saveOrUpdate(dinosaur1);

        Dinosaur dinosaur2 = new Dinosaur(paddock2,"Velociraptor","Carnivores", 600,"Red");
        DBHelper.saveOrUpdate(dinosaur2);

        Dinosaur dinosaur3 = new Dinosaur( paddock3,"Spinosaurus","Herbivores", 200,"Purple");
        dinosaur3.setHealthValue(40);
        DBHelper.saveOrUpdate(dinosaur3);

        Dinosaur dinosaur4 = new Dinosaur(paddock1,"Triceratops","Carnivores", 900,"Red");
        DBHelper.saveOrUpdate(dinosaur4);

        Dinosaur dinosaur5 = new Dinosaur(paddock2,"Stegosaurus","Carnivores", 650,"Grey");
        DBHelper.saveOrUpdate(dinosaur5);


        Dinosaur dinosaur6 = new Dinosaur(paddock1,"Brachiosaurus","Carnivores", 300,"Green");
        DBHelper.saveOrUpdate(dinosaur6);


        Dinosaur dinosaur7 = new Dinosaur(paddock3,"Allosaurus","Carnivores", 500,"Red");
        DBHelper.saveOrUpdate(dinosaur7);


        Park park = new Park("Dino World",5000,250);
        DBHelper.saveOrUpdate(park);

        Visitor visitor1 = new Visitor("Steven Bonner",300,27,182);
        DBHelper.saveOrUpdate(visitor1);

        Visitor visitor2 = new Visitor("Derek Leach", 500, 34,190);
        DBHelper.saveOrUpdate(visitor2);

        Visitor visitor3 = new Visitor("John Adams",3,56,167);
        DBHelper.saveOrUpdate(visitor3);

        DBPark.addDinosaurToPark(dinosaur1, park);

        DBPaddock.addDinosaurToPaddock(dinosaur2, paddock1);

        DBVisitor.addVisitorToPark(visitor1, park);


    }
}
