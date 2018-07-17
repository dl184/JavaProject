package db;

import models.Dinosaur;
import models.Park;


public class DBPark{


    public static void addDinosaurToPark(Dinosaur dinosaur, Park park) {
        park.addDinosaur(dinosaur);
        DBHelper.saveOrUpdate(park);
        DBHelper.saveOrUpdate(dinosaur);
        }



}

