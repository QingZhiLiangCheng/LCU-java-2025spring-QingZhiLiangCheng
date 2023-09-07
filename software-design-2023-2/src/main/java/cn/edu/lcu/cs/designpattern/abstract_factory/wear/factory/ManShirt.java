package cn.edu.lcu.cs.designpattern.abstract_factory.wear.factory;

public class ManShirt implements Shirt {
    private Double price;

    public ManShirt(Double price) {
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
