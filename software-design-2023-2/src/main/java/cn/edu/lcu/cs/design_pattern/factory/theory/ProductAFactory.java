package cn.edu.lcu.cs.design_pattern.factory.theory;

/**
 * 产品A的工厂，只生产产品A
 */
public class ProductAFactory implements ProductFactory {
    /**
     * @return 生产的产品A
     */
    @Override
    public Product build() {
        ProductA productA = new ProductA();
        System.out.println(this + "\t创建了\t" + productA);
        return productA;
    }
}
