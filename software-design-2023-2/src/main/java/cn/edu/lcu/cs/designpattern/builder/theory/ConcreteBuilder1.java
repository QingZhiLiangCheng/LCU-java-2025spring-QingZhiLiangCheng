package cn.edu.lcu.cs.designpattern.builder.theory;

/**
 * 具体建造者1
 *
 * @author: ling
 * @since: 2021-09-07 15:23
 **/
public class ConcreteBuilder1 implements Builder {
    private Product product;

    public ConcreteBuilder1() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("partA1");
    }

    @Override
    public void buildPartB() {
        product.setPartB("partB1");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
