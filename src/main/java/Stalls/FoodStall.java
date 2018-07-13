package Stalls;

import javax.persistence.*;

@Entity
@Table(name="foodstall")
public class FoodStall extends Stall {

    private int id;
    private String name;

    public FoodStall(){
        }


    public FoodStall(String name) {
        this.name = name;
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
}
