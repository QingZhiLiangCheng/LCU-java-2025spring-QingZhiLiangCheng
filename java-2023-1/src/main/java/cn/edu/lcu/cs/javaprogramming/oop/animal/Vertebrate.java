package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

/**
 * 脊椎动物
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Vertebrate {
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

    public abstract void breath();

    public abstract void eat();

    /**
     * 繁殖
     */
    public abstract void reproduce();

    /**
     * 养育后代的方式
     */
    public abstract void feed();

    public abstract void sleep();
}
