package cn.edu.lcu.cs.designpattern.visitor.cart;

public class Client {
    public static void main(String[] args) {
        ShopCart cart = new ShopCart();
        cart.add(new Apple("红富士", "特级果", 5.0, 2.5));
        cart.add(new Apple("蛇果", "残次果", 1.0, 3.0));
        cart.add(new Book("123456", "软件设计模式", 30.0, "豆瓣评分4.0"));
        cart.add(new Book("654321", "大话设计模式", 45.0, "图灵奖系列图书"));

        Visitor customer = new Customer();
        cart.accept(customer);

        Visitor saler = new Saler();
        cart.accept(saler);
    }
}
