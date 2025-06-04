package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.oop.animal;

public class Whale extends Mammal implements Swimmable {
    @Override
    public void swim() {
        System.out.println(getName() + "能游泳");
    }

}
