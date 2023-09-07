package cn.edu.lcu.cs.designpattern.abstract_factory.wear.factory;

public class ManSuit implements Suit {
    private Double price;

    public ManSuit(Double price) {
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
