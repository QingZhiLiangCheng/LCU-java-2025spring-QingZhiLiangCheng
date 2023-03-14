package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

/**
 * 蝙蝠类
 *
 * @author Ling
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bat extends Mammal {


    public void eat() {
        System.out.println("喜欢吃虫子");
    }

    public void fly() {
        System.out.println("会飞行");
    }

    public void sleep() {
        System.out.println("昼伏夜出");
    }
}
