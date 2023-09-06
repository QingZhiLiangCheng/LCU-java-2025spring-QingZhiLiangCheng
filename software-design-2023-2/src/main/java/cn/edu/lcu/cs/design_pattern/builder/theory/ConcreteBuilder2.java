package cn.edu.lcu.cs.design_pattern.builder.theory;

/**
 * 具体建造者2
 *
 * @author: ling
 * @since: 2021-09-07 15:23
 **/
public class ConcreteBuilder2 implements Builder {
    private Product product;

    public ConcreteBuilder2() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("partA2");
    }

    @Override
    public void buildPartB() {
        product.setPartB("partB2");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
