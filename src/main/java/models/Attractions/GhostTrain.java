package models.Attractions;

public class GhostTrain {

    private int id;
    private String name;

    public GhostTrain(){
        }

    public GhostTrain(String name) {
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
