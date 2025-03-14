package cn.edu.lcu.cs.javaprogramming.oop.animal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
    private int age;
    private String name;
    private String gender;
    //    private Date birthdate;
    private LocalDate birthdate;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * 默认的构造方法，编译器一般会自动添加。
     * 但是，如果类中定义了至少一个带参数的构造方法，默认构造方法就不会自动添加。
     */
    public Cat() {

    }

    public Cat(String gender, String name) {
        this.gender = gender;
        this.name = name;
    }

    /**
     * ctrl alt shift 左右方向，移动参数的位置。
     * @param age
     * @param birthdate
     * @param gender
     * @param name
     */
    public Cat(String name, int age, String gender, LocalDate birthdate) {
        this.age = age;
        this.birthdate = birthdate;
        this.gender = gender;
        this.name = name;
    }

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

}