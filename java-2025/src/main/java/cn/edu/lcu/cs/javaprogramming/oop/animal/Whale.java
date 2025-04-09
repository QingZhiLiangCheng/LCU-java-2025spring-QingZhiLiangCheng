package cn.edu.lcu.cs.javaprogramming.oop.animal;

public class Whale extends Mammal implements Swimmable {
    @Override
    public void swim() {
        System.out.println(getName() + "能游泳");
    }

}
