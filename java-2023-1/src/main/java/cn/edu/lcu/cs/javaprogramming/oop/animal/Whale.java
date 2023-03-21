package cn.edu.lcu.cs.javaprogramming.oop.animal;

public class Whale extends Mammal implements Swimmable {
    @Override
    public void eat() {
        System.out.println("喜欢吃海鲜");
    }

    @Override
    public void reproduce() {
        System.out.println("都是胎生的");
    }

    @Override
    public void sleep() {
        System.out.println("两个脑半球轮流睡觉");
    }

    @Override
    public void swim() {

    }
}
