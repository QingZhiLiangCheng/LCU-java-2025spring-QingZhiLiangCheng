package cn.edu.lcu.cs.design_pattern.abstract_factory.wear;

public class WomanSuit implements Suit {
    private Double price;

    public WomanSuit(Double price) {
        this.price = price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
