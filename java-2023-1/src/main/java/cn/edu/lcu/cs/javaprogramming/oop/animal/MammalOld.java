package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

/**
 * 猴子类
 *
 * @author Ling
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class MammalOld {
    private String name;
    /**
     * 种类名称
     */
    private String species;
    private Date birthday;
    private String color;
    private double weight;
    private String gender;
    /**
     * 体温类型（冷血、温血）
     */
    private String temperature;


    public void breath() {
        System.out.println("用肺呼吸");
    }

    public abstract void eat();

    public void reproduce() {
        System.out.println("胎生");
    }

    public void feed() {
        System.out.println("用乳汁养育后代");
    }

    public abstract void sleep();
}
