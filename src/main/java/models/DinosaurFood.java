package models;

import javax.persistence.*;

@Entity
@Table(name="dinosaurfood")
public class DinosaurFood {

    private int id;
    private String name;
    private Dinosaur dinosaur;
    private Paddock paddock;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="dinosaur_id", nullable = true)
    public Dinosaur getDinosaur() {
        return dinosaur;
    }

    public void setDinosaur(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="paddock_id", nullable = true)
    public Paddock getPaddock() {
        return paddock;
    }

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }
}

    
