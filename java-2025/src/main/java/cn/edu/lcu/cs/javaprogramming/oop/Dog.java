package cn.edu.lcu.cs.javaprogramming.oop;


import java.util.Date;

/**
 * @author Ling
 */
public class Dog {
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

    public Dog(String name, String breed, String sex) {
        // 改变参数的顺序 ctrl alt shift 左右箭头
        this.name = name;
        this.breed = breed;
        this.sex = sex;
    }

// 方法签名 method signatures 识别的依据 方法名称，参数类型，参数个数，参数顺序，与参数名称无关
//    public Dog(String name, String sex, String origin) {
//        this.name = name;
//        this.sex = sex;
//        this.origin = origin;
//    }

    /**
     * 无参构造方法，就是缺省的构造方法。如果没有明确定义任何构造方法，编译器自动添加一个缺省的构造方法。
     */
    public Dog() {

    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    private String origin;

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

    public static void main(String[] args) {
        Dog cat = new Dog();

        System.out.println(cat);
        System.out.println(cat.toString());
    }

}
