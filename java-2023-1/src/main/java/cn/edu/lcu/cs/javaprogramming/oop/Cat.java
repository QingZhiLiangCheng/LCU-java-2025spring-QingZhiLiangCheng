package cn.edu.lcu.cs.javaprogramming.oop;


import java.util.Date;

/**
 * @author Ling
 */
//public class Cat extends Object {
public class Cat {
    private String name;
    private Date birthdate;
    private String breed;
// 某些属性可以通过其它的字段计算出来，所以不需要明确定义这样的字段
//    private int age;

    //    颜色，身高，体重，体长，性别，原产地
    private String color;

    private int height;
    private int weight;
    private int length;

    private String sex;
    private String origin;

    public int getAge() {
        return 18;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

//    @Override
//    public String toString() {
//        return "Cat{" +
//                "name='" + name + '\'' +
//                ", birthdate=" + birthdate +
//                ", breed='" + breed + '\'' +
//                ", color='" + color + '\'' +
//                ", height=" + height +
//                ", weight=" + weight +
//                ", length=" + length +
//                ", sex='" + sex + '\'' +
//                ", origin='" + origin + '\'' +
//                '}';
//    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("小明");
        cat.setBirthdate(new Date());
        cat.setBreed("狗");
        cat.setColor("红色");
        cat.setHeight(180);
        cat.setWeight(80);
        cat.setLength(180);
        cat.setSex("男");
        cat.setOrigin("北京");
        System.out.println(cat);
        System.out.println(cat.toString());
    }

}
