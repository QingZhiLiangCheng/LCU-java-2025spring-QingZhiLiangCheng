package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture06.animal;

public class Bat extends Mammal implements Fliable {
    @Override
    public void fly() {
        System.out.println(getName() + "会飞");
    }
}
