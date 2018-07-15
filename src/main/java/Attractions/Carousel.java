package Attractions;

import Behaviours.IReviewed;
import Behaviours.ITicketed;
import models.Visitor;

public class Carousel extends Attraction implements ITicketed, IReviewed {

    private int id;
    private String name;


    public Carousel() {
    }

    public Carousel(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double defaultPrice() {
        return 4.80;
    }

    public int Rating(Visitor visitor) {
        return rating;
    }

}