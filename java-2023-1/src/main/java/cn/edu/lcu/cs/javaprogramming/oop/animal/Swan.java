package cn.edu.lcu.cs.javaprogramming.oop.animal;

/**
 * 天鹅类
 *
 * @author LAB
 */
public class Swan extends Bird implements Swimmable {
    @Override
    public void eat() {
        System.out.println("喜欢吃水草");
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
    @Override
    public void swim() {
        System.out.println("都是游泳高手");
    }

    /**
     * 会飞
     */
    public void fly() {
        System.out.println("都是飞行高手");
    }
}
