package cn.edu.lcu.cs.design_pattern.factory.theory;

public class ProductBFactory implements ProductFactory {
    @Override
    public Product build() {
        ProductB productB = new ProductB();
        System.out.println(this + "\t创建了\t" + productB);
        return productB;
    }
}
