package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

/**
 * 蝙蝠类
 *
 * @author Ling
 */
public class Bat extends Mammal implements Flyable {


    @Override
    public void eat() {
        System.out.println("喜欢吃虫子");
    }

    @Override
    public void reproduce() {
        System.out.println("胎生的");
    }

    @Override
    public void fly() {
        System.out.println("会飞行");
    }

    @Override
    public void sleep() {
        System.out.println("昼伏夜出");
    }
}
