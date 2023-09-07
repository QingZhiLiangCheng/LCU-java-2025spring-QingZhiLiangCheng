package cn.edu.lcu.cs.designpattern.visitor.cart.another;

/**
 * 销售人员访问商品，称重，设置打折优惠等信息。
 */
public class Saler extends Visitor {
    @Override
    public void visit(Book book) {
        switch (book.getName()) {
            case "软件设计模式":
                book.setPrice(book.getPrice() * 0.5); // 此书半价
                break;
            case "大话设计模式":
                book.setPrice(book.getPrice() * 0.9); // 九折优惠
                break;
        }
        System.out.println("销售关注价格：" + book.getName() + "\t￥" + book.getPrice());
    }

    @Override
    public void visit(Apple apple) {
        switch (apple.getName()) {
            case "红富士":
                apple.setQuantity(5.0); // 称重，5斤
                break;
            case "蛇果":
                apple.setUnitPrice(apple.getUnitPrice() * 0.5); // 单价五折优惠
                apple.setQuantity(3.0); // 3斤
                break;
        }
        System.out.println("销售关注价格：" + apple.getName() + "\t￥" + apple.getPrice() + "\t重量（斤）" + apple.getQuantity());
    }
}
