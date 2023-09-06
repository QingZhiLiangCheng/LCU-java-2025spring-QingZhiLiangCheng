package cn.edu.lcu.cs.design_pattern.visitor.pet;

public class Dog implements Pet {

    @Override
    public void accept(Feeder feeder) {
        feeder.feed(this);
        System.out.println("好好吃，汪汪汪！！！");
    }
}