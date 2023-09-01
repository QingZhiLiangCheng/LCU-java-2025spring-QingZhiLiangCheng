package cn.edu.lcu.cs.javaprogramming.uml;

public class Car {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void move() {
        System.out.println(brand + " 跑起来了");
    }
}
