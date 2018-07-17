package models;

import Behaviours.ITicketed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="paddock")
public class Paddock implements ITicketed {

    private int id;
    private String name;
    private int capacity;
    private DinosaurFood food;
    private List<Dinosaur> dinosaurs;

    public Paddock() {
    }

    public Paddock(String name, int capacity, DinosaurFood food) {
        this.name = name;
        this.capacity = capacity;
        this.food = food;
        this.dinosaurs = new ArrayList<Dinosaur>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column(name = "food")
    public DinosaurFood getFood() {
        return food;
    }

    public void setFood(DinosaurFood food) {
        this.food = food;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paddock", fetch = FetchType.LAZY)
    public List<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(List<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }

    public void addDinosaur(Dinosaur dinosaurs) {
        this.dinosaurs.add(dinosaurs);
    }

    public double defaultPrice() {
        return 20.50;
    }

}
