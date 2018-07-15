package models;

import javax.persistence.*;

@Entity
@Table(name="visitors")
public class Visitor {

    Park park;

    private int id;
    private String name;
    private int wallet;
    private int age;
    private int height;

    public Visitor(){
        }

    public Visitor(String name, int wallet, int age, int height) {
        this.name = name;
        this.wallet = wallet;
        this.age = age;
        this.height = height;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name="wallet")
    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    @ManyToOne
    @JoinColumn(name="park_id", nullable=true)
    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name="height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
