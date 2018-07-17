package db;

import models.*;


public class Seeds {

    public static void seedData() {

        Paddock paddock1 = new Paddock("Trex Cell",4, DinosaurFood.PLANTS);
        DBHelper.saveOrUpdate(paddock1);

        Paddock paddock2 = new Paddock("VelociraptorCell",5, DinosaurFood.GOAT);
        DBHelper.saveOrUpdate(paddock2);

        Paddock paddock3 = new Paddock("BarneyCell", 20, DinosaurFood.COW);
        DBHelper.saveOrUpdate(paddock3);

        Dinosaur dinosaur1 = new Dinosaur("Tyrannosaurus rex", "Prehistoric Animals","Carnivores",609,"Green");
        DBHelper.saveOrUpdate(dinosaur1);

        Dinosaur dinosaur2 = new Dinosaur("Velociraptor","Raptors","Carnivores", 182,"Red");
        DBHelper.saveOrUpdate(dinosaur2);

        Dinosaur dinosaur3 = new Dinosaur( "Barney","Tyrannosaurus rex","Herbivores", 152,"Purple");
        dinosaur3.setHealthValue(40);
        DBHelper.saveOrUpdate(dinosaur3);

        Park park = new Park("Dino World",5000,250);
        DBHelper.saveOrUpdate(park);

        Visitor visitor1 = new Visitor("Jimmy Bob",100,25,182);
        DBHelper.saveOrUpdate(visitor1);

        Visitor visitor2 = new Visitor("Rick White", 50, 18,152);
        DBHelper.saveOrUpdate(visitor2);

        Visitor visitor3 = new Visitor("IT",30000,32,190);
        DBHelper.saveOrUpdate(visitor3);

        DBPark.addDinosaurToPark(dinosaur1, park);

        DBPaddock.addDinosaurToPaddock(dinosaur2, paddock1);

        DBVisitor.addVisitorToPark(visitor1, park);


    }
}
