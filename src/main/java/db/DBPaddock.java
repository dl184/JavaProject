package db;

import models.Dinosaur;
import models.Paddock;

public class DBPaddock {
    public static void addDinosaurToPaddock(Dinosaur dinosaur, Paddock paddock) {
        paddock.addDinosaur(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(paddock);
    }

    public static void removeDinosaurFromPaddock(Dinosaur dinosaur, Paddock paddock) {
        paddock.removeDinosaur(dinosaur);
        DBHelper.saveOrUpdate(dinosaur);
        DBHelper.saveOrUpdate(paddock);
    }
}