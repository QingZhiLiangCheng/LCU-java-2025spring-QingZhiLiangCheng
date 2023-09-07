package cn.edu.lcu.cs.designpattern.visitor.cart.another;

import lombok.Data;

/**
 * 每个具体的商品类，都有对应的访问方法。
 */
@Data
public abstract class Visitor {
    private String name;

    public abstract void visit(Book book);

    public abstract void visit(Apple apple);
}
