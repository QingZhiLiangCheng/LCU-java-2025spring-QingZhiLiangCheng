package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.oop.animal;

import cn.edu.lcu.cs.javaprogramming.oop.animal.Mammal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 猴子类，使用Lombok进行修饰。
 */
@Getter
@Setter
@ToString
public class Monkey extends Mammal {

    public Monkey() {
        super();
        this.setSpecies("猴子");
    }

    // 构造函数
    public Monkey(String name, LocalDate birthDate, String color,
                  double weight, String gender, double height) {
        this();
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setColor(color);
        this.setWeight(weight);
        this.setGender(gender);
        this.setHeight(height);
    }


    // 行为：猴子行走
    public void walk() {
        System.out.println(getName() + "通常四足行走，偶尔也会双足行走。");
    }

    // 行为：猴子爬树
    public void climb() {
        System.out.println(getName() + " is climbing a tree.");
    }

}