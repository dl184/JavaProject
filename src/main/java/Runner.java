import db.DBHelper;
import models.Dinosaur;
import models.Paddock;
import models.Park;
import models.Visitor;

public class Runner {

    public static void main(String[] args) {

        Dinosaur dinosaur1 = new Dinosaur("Tyrannosaurus rex", "Prehistoric Animals","Carnivores",609,"Green");
        DBHelper.save(dinosaur1);

        Dinosaur dinosaur2 = new Dinosaur("Velociraptor","Raptors","carnivore", 182,"red");
        DBHelper.save(dinosaur2);

        Dinosaur dinosaur3 = new Dinosaur("barney","Tyrannosaurus rex","Salad", 152,"Purple");
        DBHelper.save(dinosaur3);

        Paddock paddock1 = new Paddock("Trex Cell",1,"Cows");
        DBHelper.save(paddock1);

        Paddock paddock2 = new Paddock("VelociraptorCell",5,"Goats");
        DBHelper.save(paddock2);

        Paddock paddock3 = new Paddock("BarneyCell", 20,"verde salad");
        DBHelper.save(paddock3);

        Park park = new Park("Dino World",5000,250);
        DBHelper.save(park);

        Visitor visitor1 = new Visitor("Jimmy Bob",100,25,182);
        DBHelper.save(visitor1);

        Visitor visitor2 = new Visitor("Rick White", 50, 18,152);
        DBHelper.save(visitor2);

        Visitor visitor3 = new Visitor("IT",30000,32,190);
        DBHelper.save(visitor3);




    }
}
