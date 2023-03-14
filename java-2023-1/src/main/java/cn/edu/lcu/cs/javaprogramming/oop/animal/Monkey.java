package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Monkey {
    // 名称，种类名称，出生日期，颜色，体重，性别，体温类型（冷血、温血）
    private String name;
    private String species;
    private Date birthday;
    private String color;
    private double weight;
    private String gender;
    private String temperature;


//    呼吸，行走，游泳，飞翔，生育后代，哺育后代，进食
    public void breath() {
        System.out.println("用肺呼吸");
    }

    public void walk() {
        System.out.println("会走");
    }

    public void eat() {
        System.out.println("喜欢吃水果");
    }

    public void reproduce() {
        System.out.println("胎生");
    }

    public void feed() {
        System.out.println("用乳汁养育后代");
    }
}
