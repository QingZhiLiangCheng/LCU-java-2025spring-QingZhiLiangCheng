package cn.edu.lcu.cs.designpattern.abstract_factory.theory.reduced;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.buildProductA();

        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.buildProductA();
    }
}
