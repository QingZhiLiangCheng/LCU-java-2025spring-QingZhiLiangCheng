package cn.edu.lcu.cs.designpattern.command.restaurant;

/**
 * @Author Ling
 * @Date 2021/10/20 8:42
 * @Version 1.0
 */
public class Chef {
    public Cuisine cook(String cuisineName) {
        System.out.println("大厨做了道好吃的菜品 - " + cuisineName);
        return new Cuisine(cuisineName);
    }
}
