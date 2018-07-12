public class Dinosaur {

    private int id;
    private String type;
    private String bloodType;
    private int height;
    private String color;

    public Dinosaur() {
    }

    public Dinosaur(String type, String bloodType, int height, String color) {
        this.type = type;
        this.bloodType = bloodType;
        this.height = height;
        this.color = color;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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
