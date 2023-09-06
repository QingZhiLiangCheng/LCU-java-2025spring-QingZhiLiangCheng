package cn.edu.lcu.cs.basic.relationship.inherit.bird;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Bird {
    private String species;
    private String name;
    private LocalDate birthdate;
    private String color;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getAge() {
        if (birthdate != null) {
            return birthdate.until(LocalDate.now(), ChronoUnit.YEARS);
        } else {
            return -1;
        }
    }

    public void breath() {
        System.out.println("鸟类都是用肺呼吸");
    }

    public void reproduce() {
        System.out.println("鸟类都是产卵繁殖");
    }

    public abstract void fly();

    public abstract void eat();

    public abstract void swim();

    public abstract void walk();

}
