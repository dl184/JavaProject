package models.Attractions;

public class FoodStall {

    private int id;
    private String name;

    public class FoodStall(){
        }

    public FoodStall(String name) {
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
}
