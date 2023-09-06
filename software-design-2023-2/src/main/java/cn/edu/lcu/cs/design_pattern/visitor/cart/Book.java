package cn.edu.lcu.cs.design_pattern.visitor.cart;

public class Book implements Product {
    private String isbn;
    private String name;
    private Double price;
    private String quality;

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "访问了" + this.getClass().getSimpleName());
        visitor.visit(this);
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getQuality() {
        return this.quality;
    }

    public Book(String isbn, String name, Double price, String quality) {
        this.isbn = isbn;
        this.name = name;
        this.price = price;
        this.quality = quality;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
