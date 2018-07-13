package db;

import models.*;


public class Seeds {

    public static void seedData() {

        Paddock paddock = new Paddock("Paddock A", 5, DinosaurFood.PLANTS);

        Dinosaur dinosaur1 = new Dinosaur(paddock, "Tyrannosaurus rex", "Prehistoric Animals","Carnivores",609,"Green", 40);
        DBHelper.save(dinosaur1);

        Dinosaur dinosaur2 = new Dinosaur(paddock, "Velociraptor","Raptors","carnivore", 182,"red", 50);
        DBHelper.save(dinosaur2);

        Dinosaur dinosaur3 = new Dinosaur(paddock, "barney","Tyrannosaurus rex","Salad", 152,"Purple", 25);
        DBHelper.save(dinosaur3);

        Paddock paddock1 = new Paddock("Trex Cell",4, DinosaurFood.PLANTS);
        DBHelper.save(paddock1);

        Paddock paddock2 = new Paddock("VelociraptorCell",5, DinosaurFood.GOAT);
        DBHelper.save(paddock2);

        Paddock paddock3 = new Paddock("BarneyCell", 20, DinosaurFood.COW);
        DBHelper.save(paddock3);

        Park park = new Park("Dino World",5000,250);
        DBHelper.save(park);

        Visitor visitor1 = new Visitor("Jimmy Bob",100,25,182);
        DBHelper.save(visitor1);

        Visitor visitor2 = new Visitor("Rick White", 50, 18,152);
        DBHelper.save(visitor2);

        Visitor visitor3 = new Visitor("IT",30000,32,190);
        DBHelper.save(visitor3);

        DBPark.addDinosaurToPark(dinosaur1, park);

        DBPaddock.addDinosaurToPaddock(dinosaur2, paddock1);

        DBVisitor.addVisitorToPark(visitor1, park);


    }
}
