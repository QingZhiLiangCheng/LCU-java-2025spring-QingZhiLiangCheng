package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * 猴子类，使用Lombok进行修饰。
 */
@Getter
@Setter
@ToString
//@NoArgsConstructor
public class Monkey extends Mammal {


    public Monkey() {
        super();
    }

    // 构造函数
    public Monkey(String name, LocalDate birthDate, String color,
                  double weight, String gender, double height) {
        this();
        this.name = name;
        this.birthDate = birthDate;
        this.color = color;
        this.weight = weight;
        this.gender = gender;
        this.height = height;
    }


    // 行为：猴子行走
    public void walk() {
        System.out.println(name + "通常四足行走，偶尔也会双足行走。");
    }

    // 行为：猴子爬树
    public void climb() {
        System.out.println(name + " is climbing a tree.");
    }

}