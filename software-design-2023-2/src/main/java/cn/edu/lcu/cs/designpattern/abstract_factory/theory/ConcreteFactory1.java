package cn.edu.lcu.cs.designpattern.abstract_factory.theory;

/**
 * 具体工厂1，生产商品A系列与B系列的第1种商品
 */
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA buildProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB buildProductB() {
        return new ProductB1();
    }
}
