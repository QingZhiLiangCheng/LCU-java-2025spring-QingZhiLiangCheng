package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

/**
 * 猴子类
 *
 * @author Ling
 */

public class Monkey extends Mammal {


    public void walk() {
        System.out.println("会走");
    }

    @Override
    public void eat() {
        System.out.println("喜欢吃水果");
    }

    @Override
    public void reproduce() {
        System.out.println("胎生");
    }

    @Override
    public void sleep() {
        System.out.println("胎生的");

    }

}
