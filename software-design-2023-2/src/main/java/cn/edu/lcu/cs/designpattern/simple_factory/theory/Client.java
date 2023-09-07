package cn.edu.lcu.cs.designpattern.simple_factory.theory;

public class Client {
    public static void main(String[] args) {
        // 调用静态工厂方法，生产产品A。客户仅需提供商品型号即可。
        Product productA = ProductFactory.build("productA");
        // 使用产品A
        productA.print();

        Product productB = ProductFactory.build("productB");
        productB.print();
    }
}
