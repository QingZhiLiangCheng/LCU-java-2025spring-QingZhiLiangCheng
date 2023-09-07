package cn.edu.lcu.cs.designpattern.visitor.pet;

public class Owner implements Feeder {

    @Override
    public void feed(Cat cat) {
        System.out.println("主人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("主人喂食狗");
    }
}