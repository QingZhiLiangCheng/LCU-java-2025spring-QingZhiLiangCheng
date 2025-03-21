package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture05;

import java.time.LocalDate;

/**
 * 传统的、经典的猴子类定义，拥有显式的getter与setter。
 */
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

    // 方法：获取猴子的名字
    public String getName() {
        return name;
    }

    // 方法：获取猴子的出生日期
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        int age = 0;
        // TODO 根据出生日期与当前时间，计算年龄，算法暂时省略。
        age = LocalDate.now().getYear()-getBirthDate().getYear();
        return age;
    }


    // 方法：获取猴子的种类
    public String getSpecies() {
        return species;
    }

    // 方法：获取猴子的颜色
    public String getColor() {
        return color;
    }

    // 方法：获取猴子的体重
    public double getWeight() {
        return weight;
    }

    // 方法：获取猴子的性别
    public String getGender() {
        return gender;
    }

    // 方法：获取猴子的身高
    public double getHeight() {
        return height;
    }

    // 方法：获取猴子的体温类型
    public String getTemperatureType() {
        return temperatureType;
    }

    // 行为：猴子行走
    public void walk() {
        System.out.println(name + "通常四足行走，偶尔也会双足行走。");
    }

    // 行为：猴子爬树
    public void climb() {
        System.out.println(name + " is climbing a tree.");
    }

    // 行为：猴子生殖
    public void reproduce() {
        System.out.println(species + "是胎生的。");
    }

    // 行为：猴子哺育后代
    public void careForOffspring() {
        System.out.println(species + "用奶水哺育后代");
    }

}