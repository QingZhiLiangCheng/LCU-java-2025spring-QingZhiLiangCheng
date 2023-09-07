package cn.edu.lcu.cs.designpattern.abstract_factory.theory;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.buildProductA();
        ProductB productB1 = factory1.buildProductB();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.buildProductA();
        ProductB productB2 = factory2.buildProductB();
    }
}
