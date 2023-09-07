package cn.edu.lcu.cs.designpattern.visitor.cart;

public abstract class Visitor {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void visit(Book book);

    public abstract void visit(Apple apple);
}
