package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

/**
 * 恒温动物类，包括哺乳动物与鸟类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public abstract class Endotherm {
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

    /**
     * 繁殖
     */
    public abstract void reproduce();

    public abstract void feed();

    public abstract void sleep();
}
