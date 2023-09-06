package cn.edu.lcu.cs.design_pattern.visitor.cart.another;

import lombok.Data;

@Data
public class Apple extends Product {
    private Double unitPrice;
    private Double quantity;

    public Apple(String name, double unitPrice) {
        this.unitPrice = unitPrice;
        setName(name);
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "访问了" + this.getClass().getSimpleName());
        visitor.visit(this);
    }

    @Override
    public Double getPrice() {
        return unitPrice * quantity;
    }

}
