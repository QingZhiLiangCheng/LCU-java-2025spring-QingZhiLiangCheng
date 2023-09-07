package cn.edu.lcu.cs.designpattern.simple_factory.theory;

public class ProductFactory {
    /**
     * 根据型号参数生产不同的商品
     *
     * @param model
     * @return
     */
    public static Product build(String model) {
        Product product = null;
        switch (model) {
            case "productA":
                product = new ProductA();
                break;
            case "productB":
                product = new ProductB();
                break;
            default:
                product = null;
        }
        return product;
    }
}
