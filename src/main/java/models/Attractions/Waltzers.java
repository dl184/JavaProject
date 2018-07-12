package models.Attractions;

public class Waltzers {

    private int id;
    private String name;

    public Waltzers(){
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
}
