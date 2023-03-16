package cn.edu.lcu.cs.javaprogramming.oop.animal;

public abstract class Bird extends Endotherm {
    public Bird() {
    }

    @Override
    public void reproduce() {
        System.out.println("都下蛋");
    }
}
