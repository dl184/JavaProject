package Stalls;

import Behaviours.ISecurity;
import models.Visitor;

import javax.persistence.*;

@Entity
@Table(name="barstall")
public class BarStall extends Stall implements ISecurity {


    private int id;
    private String name;

    public BarStall(){
        }

    public BarStall(String name) {
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

    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() > 17) {
            return true;
        }
        return false;
    }
}
