package cn.edu.lcu.cs.designpattern.visitor.cart.another;

import lombok.Data;

@Data
public class Book extends Product {
    private String isbn;

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "访问了" + this.getClass().getSimpleName());
        visitor.visit(this);
    }

    public Book(String isbn, String name, Double price) {
        this.isbn = isbn;
        setName(name);
        setPrice(price);
    }

}
