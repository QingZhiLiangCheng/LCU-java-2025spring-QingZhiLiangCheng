package cn.edu.lcu.cs.design_pattern.visitor.cart.another;

import lombok.Data;

@Data
public abstract class Product {
    private String name;
    private Double price;
    private String quality; // 商品质量

    public abstract void accept(Visitor visitor);
}
