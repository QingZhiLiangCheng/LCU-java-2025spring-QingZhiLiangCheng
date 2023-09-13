package cn.edu.lcu.cs.designpattern.factory.theory;

/**
 * 工厂方法模式客户类
 */
public class ProductFactoryClient {
    public static void main(String[] args) {
        // 声明抽象工厂（或工厂接口）类型的变量
        ProductFactory factory = null;
        // 用具体工厂子类为其赋值
        factory = new ProductAFactory();
        // 调用工厂的实例方法进行生产，利用了多态的特性，动态生成不同的产品
        Product productA = factory.build();
        productA.print(); // 使用产品A

        factory = new ProductBFactory();
        Product productB = factory.build();
        productB.print();

        // 创建产品D
        factory = new ProductDFactory();
        Product product = factory.build();
        System.out.println("product = " + product);
    }
}
