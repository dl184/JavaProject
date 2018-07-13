package Attractions;

import Behaviours.ISecurity;
import Behaviours.ITicketed;
import models.Visitor;

public class Waltzers extends Attraction implements ITicketed, ISecurity {

    private int id;
    private String name;

    public Waltzers() {
    }

    public Waltzers(String name) {
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

    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() > 12) {
            return true;
        }
        return false;
    }

    public double defaultPrice() {
        return 5.50;
    }
}
