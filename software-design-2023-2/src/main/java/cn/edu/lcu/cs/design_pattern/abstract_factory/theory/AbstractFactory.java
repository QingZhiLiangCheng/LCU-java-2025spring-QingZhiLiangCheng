package cn.edu.lcu.cs.design_pattern.abstract_factory.theory;

/**
 * 抽象工厂，生产商品A系列与B系列的对象
 */
public interface AbstractFactory {
    ProductA buildProductA();

    ProductB buildProductB();
}
