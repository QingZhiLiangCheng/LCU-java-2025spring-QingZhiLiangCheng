package cn.edu.lcu.cs.design_pattern.abstract_factory.wear;

public class WomanShoes implements Shoes {
    private Double price;

    public WomanShoes(Double price) {
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
