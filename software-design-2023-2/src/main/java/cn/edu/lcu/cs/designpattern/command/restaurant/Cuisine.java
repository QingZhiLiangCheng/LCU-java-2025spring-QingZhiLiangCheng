package cn.edu.lcu.cs.designpattern.command.restaurant;

import lombok.Data;

/**
 * @Description 菜品
 * @Author Ling
 * @Date 2021/10/20 8:47
 * @Version 1.0
 */
@Data
public class Cuisine {
    private String name;
    private double price;

    public Cuisine() {
    }

    public Cuisine(String cuisineName) {
        this.name = cuisineName;
    }

    public Cuisine(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
