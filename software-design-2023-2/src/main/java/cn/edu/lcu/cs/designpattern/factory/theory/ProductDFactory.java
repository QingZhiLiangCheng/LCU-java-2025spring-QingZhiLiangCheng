package cn.edu.lcu.cs.designpattern.factory.theory;

public class ProductDFactory implements ProductFactory {
    @Override
    public Product build() {
        Product product = new ProductD();
        System.out.println(this + "\t创建了\t" + product);
        return product;
    }
}
