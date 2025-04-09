package cn.edu.lcu.cs.javaprogramming.oop.animal;

public class Bat extends Mammal implements Flyable {
    @Override
    public void fly() {
        System.out.println(getName() + "会飞");
    }
}
