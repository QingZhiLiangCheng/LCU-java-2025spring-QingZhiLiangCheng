package cn.edu.lcu.cs.designpattern.factory.theory;

public class ProductCFactory implements ProductFactory {
    @Override
    public Product build() {
        ProductC productC = new ProductC();
        System.out.println(this + "\t创建了\t" + productC);
        return productC;
    }
}
