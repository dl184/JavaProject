package models;

import javax.persistence.*;

@Entity
@Table(name="dinosaurFood")
public enum DinosaurFood {

    PLANTS("Plants"),
    COW("Cow"),
    GOAT("Goat");

    private String foodType;
    private int id;

    DinosaurFood(String foodType) {
        this.foodType = foodType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }
    DinosaurFood() {
    }
}

    
