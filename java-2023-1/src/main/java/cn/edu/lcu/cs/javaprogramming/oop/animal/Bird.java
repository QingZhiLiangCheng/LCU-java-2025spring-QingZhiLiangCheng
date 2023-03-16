package cn.edu.lcu.cs.javaprogramming.oop.animal;

public abstract class Bird extends Endotherm {
    public Bird() {
    }

    @Override
    public void reproduce() {
        System.out.println("都下蛋");
    }

    // 会游泳
    public void walk() {
        System.out.println("都会走");
    }
}
