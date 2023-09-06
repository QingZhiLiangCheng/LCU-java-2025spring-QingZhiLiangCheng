package cn.edu.lcu.cs.design_pattern.abstract_factory.wear;

public class ManShoes implements Shoes {
    private Double price;

    public ManShoes(Double price) {
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
