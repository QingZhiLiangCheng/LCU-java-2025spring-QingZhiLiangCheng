package cn.edu.lcu.cs.design_pattern.visitor.cart;

import java.util.ArrayList;
import java.util.List;

public class ShopCart {
    private List<Product> products = new ArrayList<>();
    private Double totalPrice = 0.0;


    public void accept(Visitor visitor) {
        products.forEach(product -> product.accept(visitor));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void add(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public void remove(Product product) {
        products.remove(product);
        totalPrice -= product.getPrice();
    }
}
