package cn.edu.lcu.cs.design_pattern.visitor.cart;

public interface Product {
    void accept(Visitor visitor);
    double getPrice();
    String getName();

    /**
     * 商品质量
     * @return
     */
    String getQuality();

}
