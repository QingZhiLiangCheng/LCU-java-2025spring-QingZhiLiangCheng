package cn.edu.lcu.cs.designpattern.visitor.cart;

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
