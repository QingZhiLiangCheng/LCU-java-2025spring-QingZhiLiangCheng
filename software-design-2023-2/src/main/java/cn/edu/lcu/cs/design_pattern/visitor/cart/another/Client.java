package cn.edu.lcu.cs.design_pattern.visitor.cart.another;

public class Client {
    public static void main(String[] args) {
        // 获取装满商品的购物车对象
        ShopCart cart = buildShopCart();

        // 以客户的视角访问购物车中的商品，主要关心商品的质量。
        Visitor customer = new Customer();
        cart.accept(customer);

        // 以销售人员的角度访问购物车中的商品，主要关注价格、重量、打折优惠等信息。
        Visitor saler = new Saler();
        cart.accept(saler);
        // 当销售人员访问完购物车中所有商品后，总价格就确定了。
        System.out.println("购物车总价格：\t￥" + cart.getTotalPrice());
    }

    private static ShopCart buildShopCart() {
        ShopCart cart = new ShopCart();
        cart.add(new Apple("红富士", 4.99)); // 名称，单价
        cart.add(new Apple("蛇果", 5.99));
        cart.add(new Book("123456", "软件设计模式", 23.0));
        cart.add(new Book("654321", "大话设计模式", 32.0));
        return cart;
    }
}
