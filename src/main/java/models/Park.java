package models;


import javax.persistence.*;
import javax.swing.plaf.ViewportUI;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="park")
public class Park {


    private int id;
    private String name;
    private int till;
    private int capacity;
    private List<Dinosaur> dinosaur;
    private List<Visitor> visitors;

    public Park() {
    }

    public Park(String name, int till, int capacity) {
        this.name = name;
        this.till = till;
        this.capacity = capacity;
        this.visitors = new ArrayList<Visitor>();
        this.dinosaur = new ArrayList<Dinosaur>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "till")
    public int getTill() {
        return till;
    }

    public void setTill(int till) {
        this.till = till;
    }

    @OneToMany(mappedBy = "park", fetch = FetchType.LAZY)
    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void addDinosaur(Dinosaur dinosaur) {
        this.dinosaur.add(dinosaur);
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }
}
