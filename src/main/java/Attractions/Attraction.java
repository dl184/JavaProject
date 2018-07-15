package Attractions;

import models.Visitor;

abstract class Attraction {

    private int id;
    private String name;
    public int rating;

    public Attraction(){
        }

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
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

    public int Rating(Visitor visitor) {
        return rating;
    }

}
