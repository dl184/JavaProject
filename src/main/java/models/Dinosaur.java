package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dinosaurs")
public class Dinosaur {

    private Paddock paddock;
    private int id;
    private String type;
    private String diet;
    private int height;
    private String color;
    private int healthValue;
    private List<DinosaurFood> belly;

    public Dinosaur() {
    }

    public Dinosaur(Paddock paddock, String type, String diet, int height, String color) {
        this.paddock = paddock;
        this.type = type;
        this.diet = diet;
        this.height = height;
        this.color = color;
        this.healthValue = 100;
        this.belly = new ArrayList<>();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name = "paddock_id", nullable = true)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }


    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "diet")
    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    @Column(name = "height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "healthvalue")
    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    public List<DinosaurFood> getBelly() {
        return belly;
    }

    public void setBelly(List<DinosaurFood> belly) {
        this.belly = belly;
    }

    public void feedDinosaur(DinosaurFood dinosaurFood) {
        belly.add(dinosaurFood);
    }

    public String dinosaurRampage() {
        if (this.getHealthValue() < 26) {
            return "ROARRRR I'M HUNGRY";
        }
        return "IM LOVELY AND FULL UP";
    }

}

