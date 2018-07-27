package models;

import Behaviours.ITicketed;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="paddock")
public class Paddock implements ITicketed {

    private int id;
    private String emergency;
    private String name;
    private String type; // carnivore or herbivore
    private int capacity;
    private DinosaurFood food;
    private List<Dinosaur> dinosaurs;

    public Paddock() {
    }

    public Paddock(String name, String type, int capacity, DinosaurFood food) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.food = food;
        this.dinosaurs = new ArrayList<>();
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

    @Column(name="type") // carnivore or herbivore
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @ManyToOne
    @JoinColumn(name = "food_id")
    public DinosaurFood getFood() {
        return food;
    }

    public void setFood(DinosaurFood food) {
        this.food = food;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paddock")
    @Fetch(value = FetchMode.SUBSELECT)
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

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public void removeDinosaur(Dinosaur dinosaurs) {
        this.dinosaurs.remove(dinosaurs);
    }
}