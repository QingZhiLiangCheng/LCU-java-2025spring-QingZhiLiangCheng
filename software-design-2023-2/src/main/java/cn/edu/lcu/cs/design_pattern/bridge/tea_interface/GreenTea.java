package cn.edu.lcu.cs.design_pattern.bridge.tea_interface;

public class GreenTea implements TeaKind {
    private double price = 2.0; // 默认售价

    public GreenTea() {
    }

    public GreenTea(double price) {
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
