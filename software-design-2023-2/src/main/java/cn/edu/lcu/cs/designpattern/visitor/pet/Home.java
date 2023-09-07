package cn.edu.lcu.cs.designpattern.visitor.pet;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Pet> pets = new ArrayList<Pet>();

    public void action(Feeder feeder) {
        for (Pet pet : pets) {
            pet.accept(feeder);
        }
    }

    //添加操作
    public void add(Pet pet) {
        pets.add(pet);
    }
}