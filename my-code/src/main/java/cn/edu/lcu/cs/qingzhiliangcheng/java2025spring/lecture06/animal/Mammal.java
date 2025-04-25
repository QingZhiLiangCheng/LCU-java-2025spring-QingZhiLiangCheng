package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture06.animal;

import java.time.LocalDate;

public abstract class Mammal {
    // 属性
    protected String name;          // 名字
    protected LocalDate birthDate;  // 出生日期
    protected String species;       // 种类
    protected String color;         // 颜色
    protected double weight;        // 体重
    protected String gender;        // 性别
    protected double height;        // 身高
    protected String temperatureType; // 体温类型（冷血或温血）

    public Mammal() {
        this.species = "猴子";
        this.temperatureType = "温血";
    }

    // 行为：猴子进食
    public void eat(String food) {
        System.out.println(name + " is eating " + food + ".");
    }

    // 行为：猴子呼吸
    public void breathe() {
        System.out.println(species + "用肺呼吸。");
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getTemperatureType() {
        return temperatureType;
    }

    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType;
    }
}
