package Stalls;

public abstract class Stall {

    public String name;

    public Stall(){

    }

    public Stall(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
