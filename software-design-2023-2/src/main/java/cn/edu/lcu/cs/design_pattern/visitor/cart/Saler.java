package cn.edu.lcu.cs.design_pattern.visitor.cart;

/**
 * 销售人员访问商品，只关心价格
 */
public class Saler extends Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("销售关注价格：" + book.getName() + "\t" + book.getPrice());
    }

    @Override
    public void visit(Apple apple) {
        System.out.println("销售关注价格：" + apple.getName() + "\t" + apple.getPrice());
    }
}
