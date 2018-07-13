package Attractions;

import Behaviours.ITicketed;

public class Carousel extends Attraction implements ITicketed {

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
}