package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.oop.animals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * <h3>对猫建模，封装猫的信息</h3>
 * <ul>
 * <li>属性候选项：名称，品种名称，出生日期，年龄，颜色，身高，体重，体长，性别，原产地等等</li>
 * <li>行为候选项：呼吸，进食，生育后代，哺育后代，行走，奔跑，爬树，等等</li>
 * </ul>
 *
 * <h3>英文术语</h3>
 * <ul>
 * <li>品种breed，身高height，体重weight，体长length，出生日期birthdate，性别gender，原产地origin</li>
 * <li>行走walk，奔跑run，爬树climb tree，进食eat，呼吸breath，生殖reproduce，哺育后代feed</li>
 * </ul>
 * <p>
 * 2022/3/2 22:18
 * </p>
 *
 * @Author ling
 */
public class Cat {
    /**
     * 名字
     */
    private String name;

    /**
     * 出生日期
     */
    private LocalDate birthDate;

    /**
     * 颜色
     */
    private String color;

    /**
     * 性别
     */
    private String gender;

    /**
     * 品种名称
     */
    private String breed;

    /**
     * 原产地，如俄罗斯
     */
    private String origin;

    private double weight;

    private double height;

    private double length;

    /**
     * 默认的构造方法，不带任何参数。 <br>
     * 如果类中没有定义任何构造方法，编译器会自动添加此方法，所以称为默认构造方法。 <br>
     * 如果类中定义有任何一个构造方法，默认方法将不会被自动添加。 <br>
     * 开发工具可以辅助创建各种构造方法。
     */
    public Cat() {
    }

    /**
     * 带参数的构造方法，可以有多个。
     *
     * @param name
     * @param color
     * @param gender
     * @param origin
     */
    public Cat(String name, String color, String gender, String origin) {
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.origin = origin;
    }

    public Cat(String gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    public int getAge() {
        if (birthDate != null) {
            return (int) birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
        } else {
            return -1;
        }
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void walk() {
        System.out.println("猫当然走猫步");
    }

    public void run() {
        System.out.println("猫跑得飞快");
    }

    public void climbTree() {
        System.out.println("猫爬树666");
    }

    public void eat() {
        System.out.println("猫喜欢吃鱼");
    }

    public void breath() {
        System.out.println("猫用肺呼吸");
    }

    /**
     * 生殖
     */
    public void reproduce() {
        System.out.println("猫是猫它妈胎生的");
    }

    /**
     * 哺育后代
     */
    public void feed() {
        System.out.println("猫妈妈用乳汁哺育宝宝");
    }

    /**
     * 将类的实例转换为字符串 <br>
     * 此方法在父类 Object 中定义，默认显示类的名称+哈希值，格式不友好。 <br>
     * 如：cn.edu.lcu.cs.javaprogramming.oop.animal.Cat@3d36e4cd <br>
     * 用户可以重写此方法，用于友好的输出 <br>
     * 提示：此方法不必手写，开发工具提供了创建此方法的快捷方式。
     *
     * @return 格式友好的字符串
     */
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", origin='" + origin + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}