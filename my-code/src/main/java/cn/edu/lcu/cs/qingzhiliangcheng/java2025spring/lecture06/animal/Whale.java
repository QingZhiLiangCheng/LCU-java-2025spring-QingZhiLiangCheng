package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture06.animal;

public class Whale extends Mammal implements Swimmable {
    @Override
    public void swim() {
        System.out.println(getName() + "swim");
    }

}
