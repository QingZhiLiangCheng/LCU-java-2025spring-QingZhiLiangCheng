package cn.edu.lcu.cs.design_pattern.bridge.tea_interface;

public class RedTea implements TeaKind {
    private double price = 3.0; // 默认售价

    @Override
    public Double getPrice() {
        return price;
    }

    public RedTea(double price) {
        this.price = price;
    }

    public RedTea() {
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
