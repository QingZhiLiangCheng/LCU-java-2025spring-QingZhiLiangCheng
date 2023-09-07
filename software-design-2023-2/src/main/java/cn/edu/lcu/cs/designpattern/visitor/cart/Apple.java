package cn.edu.lcu.cs.designpattern.visitor.cart;

public class Apple implements Product {
    private String name;
    private Double price;
    private String quality;
    private Double unitPrice;
    private Double quantity;

    public Apple(String name, String quality, Double unitPrice, Double quantity) {
        this.name = name;
        this.quality = quality;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Apple() {
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "访问了" + this.getClass().getSimpleName());
        visitor.visit(this);
    }

    @Override
    public double getPrice() {
        return quantity * unitPrice;
    }

    @Override
    public String getQuality() {
        return this.quality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
