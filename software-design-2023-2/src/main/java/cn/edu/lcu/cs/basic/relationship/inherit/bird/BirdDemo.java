package cn.edu.lcu.cs.basic.relationship.inherit.bird;

public class BirdDemo {
    public static void main(String[] args) {
        // 天鹅，变量声明为父类，但是用子类对象为其赋值
        Bird swan = new Swan();
        swan.fly();
        swan.swim();
        swan.walk();
        // 企鹅
        Bird penguin = new Penguin();
        penguin.fly();  // error
        penguin.swim();
        penguin.walk();
        // 鸵鸟
        Bird ostrich = new Ostrich();
        ostrich.fly();  // error
        ostrich.swim(); // error
        ostrich.walk();
    }
}
