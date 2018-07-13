package Stalls;

import Behaviours.ISecurity;
import models.Visitor;

public class BarStall extends Stall implements ISecurity {

    private int id;
    private String name;

    public BarStall(){
        }

    public BarStall(String name) {
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
        if (visitor.getAge() > 17) {
            return true;
        }
        return false;
    }
}
