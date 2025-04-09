package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class Mammal {
    // 属性
    private String name;          // 名字
    private LocalDate birthDate;  // 出生日期
    private String species;       // 种类
    private String color;         // 颜色
    private double weight;        // 体重
    private String gender;        // 性别
    private double height;        // 身高
    private String temperatureType; // 体温类型（冷血或温血）

    public Mammal() {
        this.species = "猴子";
        this.temperatureType = "温血";
    }

    public int getAge() {
        int age = 0;

        // 根据出生日期与当前时间，计算年龄，算法暂时省略。
        if (birthDate != null) {
            LocalDate now = LocalDate.now();
            Period period = Period.between(birthDate, now);
            age = period.getYears();
        }

        return age;
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
     * <p>
     * 此方法旨在模拟特定物种调节体温的过程通过输出物种名称和其体温类型来解释为何需要调节体温
     * 体温调节是恒温动物和部分变温动物维持生命所必需的生理过程对于恒温动物（如哺乳类和鸟类），
     * 它们能够保持相对稳定的体温不受环境温度变化的影响变温动物（如爬行类和两栖类）则依赖于外部热源来调节体温
     * <p>
     * 不需要参数
     * 无返回值
     */
    public void regulateBodyTemperature() {
        System.out.println(species + "的体温类型是" + temperatureType + "，所以需要调节体温。");
    }
}
