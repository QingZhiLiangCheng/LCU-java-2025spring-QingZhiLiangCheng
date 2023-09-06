package cn.edu.lcu.cs.design_pattern.visitor.cart.another;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车类，对应于访问者模式中的ObjectStructure，持有一系列的具体元素。
 */
public class ShopCart {
    private List<Product> products = new ArrayList<>();

    /**
     * 依次让每个元素接受访问者的访问
     *
     * @param visitor
     */
    public void accept(Visitor visitor) {
        products.forEach(product -> product.accept(visitor));
    }

    public List<Product> getProducts() {
        return products;
    }

    /**
     * @return 购物车全部商品的总价格
     */
    public Double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void add(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public void remove(Product product) {
        if (product != null) {
            products.remove(product);
        }
    }
}
