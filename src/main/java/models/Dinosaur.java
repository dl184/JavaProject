package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dinosaurs")
public class Dinosaur {

    Paddock paddock;

    private int id;
    private String name;
    private String type;
    private String eats;
    private int height;
    private String color;
    private int healthValue;

    public Dinosaur() {
    }

    public Dinosaur(Paddock paddock, String name, String type, String eats, int height, String color, int healthValue) {
        this.paddock = paddock;
        this.name = name;
        this.type = type;
        this.eats = eats;
        this.height = height;
        this.color = color;
        this.healthValue = 100;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToOne
    @JoinColumn(name="paddock_id", nullable=true)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }

    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="eats")
    public String getEats() {
        return eats;
    }

    public void setEats(String eats) {
        this.eats = eats;
    }

    @Column(name="height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Column(name="color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name="healthvalue")
    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public String dinosaurRampage() {
        if (this.getHealthValue() < 25) {
            return "ROARRRR I'M HUNGRY";
        }
        return "IM LOVELY AND FULL UP";
    }

}

