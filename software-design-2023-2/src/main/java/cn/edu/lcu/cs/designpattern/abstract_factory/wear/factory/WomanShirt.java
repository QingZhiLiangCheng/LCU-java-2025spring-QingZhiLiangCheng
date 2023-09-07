package cn.edu.lcu.cs.designpattern.abstract_factory.wear.factory;

public class WomanShirt implements Shirt {
    private Double price;

    public WomanShirt(Double price) {
        this.price = price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
