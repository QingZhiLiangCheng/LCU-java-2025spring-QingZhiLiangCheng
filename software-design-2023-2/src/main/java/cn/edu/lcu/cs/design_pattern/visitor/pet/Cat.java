package cn.edu.lcu.cs.design_pattern.visitor.pet;

public class Cat implements Pet {

    @Override
    public void accept(Feeder feeder) {
        feeder.feed(this);
        System.out.println("好好吃，喵喵喵！！！");
    }
}