public class Dinosaur {

    private int id;
    private String name;
    private String type;
    private String eats;
    private int height;
    private String color;

    public Dinosaur() {
    }

    public Dinosaur(String name, String type, String eats, int height, String color) {
        this.name = name;
        this.type = type;
        this.eats = eats;
        this.height = height;
        this.color = color;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
