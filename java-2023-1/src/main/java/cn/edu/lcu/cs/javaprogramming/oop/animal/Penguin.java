package cn.edu.lcu.cs.javaprogramming.oop.animal;

public class Penguin extends Bird {
    @Override
    public void eat() {
        System.out.println("喜欢吃鱼");
    }

    @Override
    public void feed() {

    }

    @Override
    public void sleep() {

    }

   /**
    * 会游泳
    */
    public void swim() {
        System.out.println("都是游泳高手");
    }
}
