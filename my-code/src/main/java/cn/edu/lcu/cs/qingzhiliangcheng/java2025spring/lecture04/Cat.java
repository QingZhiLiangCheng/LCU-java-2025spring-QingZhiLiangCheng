package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture04;

import java.time.LocalDate;

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
 * @Author QingZhiLiangCheng
 */
public class Cat {
    private int age;
    private String name;
    private int gender;
    private LocalDate birthdate;


    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                '}';
    }

    /**
     * ctrl alt shift 左右方向
     *
     * @param age
     * @param birthdate
     * @param gender
     * @param name
     */
    public Cat(String name, int age, int gender, LocalDate birthdate) {
        this.age = age;
        this.birthdate = birthdate;
        this.gender = gender;
        this.name = name;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}