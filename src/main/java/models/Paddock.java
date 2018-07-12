package models;

public class Paddock {

    private int id;
    private String name;
    private int capacity;
    private String food;

    public Paddock() {
    }

    public Paddock(String name, int capacity, String food) {
        this.name = name;
        this.capacity = capacity;
        this.food = food;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
