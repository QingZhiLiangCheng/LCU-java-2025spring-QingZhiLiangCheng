package cn.edu.lcu.cs.designpattern.abstract_factory.theory.reduced;

/**
 * 具体工厂2，生产商品A系列与B系列的第2种商品
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA buildProductA() {
        return new ProductA2();
    }

}
