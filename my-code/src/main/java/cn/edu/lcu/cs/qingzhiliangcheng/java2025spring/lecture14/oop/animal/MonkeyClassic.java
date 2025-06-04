package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.oop.animal;

import java.time.LocalDate;
import java.time.Period;

/**
 * 传统的、经典的猴子类定义，拥有显式的getter与setter。
 */
public class MonkeyClassic {
    // 属性
    private String name;          // 名字
    private LocalDate birthDate;  // 出生日期
    private String species;       // 种类
    private String color;         // 颜色
    private double weight;        // 体重
    private String gender;        // 性别
    private double height;        // 身高
    private String temperatureType; // 体温类型（冷血或温血）
    public MonkeyClassic() {
        this.species = "猴子";
        this.temperatureType = "温血";
    }

    // 构造函数
    public MonkeyClassic(String name, LocalDate birthDate, String color,
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
        // 根据出生日期与当前时间，计算年龄，算法暂时省略。
        if (birthDate!=null) {
            LocalDate now = LocalDate.now();
            Period period = Period.between(birthDate, now);
            age = period.getYears();
        }

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

    // 行为：猴子进食
    public void eat(String food) {
        System.out.println(name + " is eating " + food + ".");
    }

    // 行为：猴子呼吸
    public void breathe() {
        System.out.println(species + "用肺呼吸。");
    }

    // 行为：猴子生殖
    public void reproduce() {
        System.out.println(species + "是胎生的。");
    }

    // 行为：猴子哺育后代
    public void careForOffspring() {
        System.out.println(species + "用奶水哺育后代");
    }

    /**
     * 调节体温的方法
     *
     * 此方法旨在模拟特定物种调节体温的过程通过输出物种名称和其体温类型来解释为何需要调节体温
     * 体温调节是恒温动物和部分变温动物维持生命所必需的生理过程对于恒温动物（如哺乳类和鸟类），
     * 它们能够保持相对稳定的体温不受环境温度变化的影响变温动物（如爬行类和两栖类）则依赖于外部热源来调节体温
     *
     * 不需要参数
     * 无返回值
     */
    public void regulateBodyTemperature() {
        System.out.println(species + "的体温类型是" + temperatureType + "，所以需要调节体温。");
    }
}