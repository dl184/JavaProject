package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dinosaurfood")
public class DinosaurFood {

    private int id;
    private String name;
    private List<Dinosaur> dinosaurs;
    private List<Paddock> paddocks;

    public DinosaurFood() {
    }

    public DinosaurFood(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(mappedBy = "belly")
    public List<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(List<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }

    @OneToMany(mappedBy = "food")
    public List<Paddock> getPaddocks() {
        return paddocks;
    }

    public void setPaddocks(List<Paddock> paddocks) {
        this.paddocks = paddocks;
    }
}
