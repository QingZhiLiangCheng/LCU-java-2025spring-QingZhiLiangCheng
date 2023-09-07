package cn.edu.lcu.cs.designpattern.visitor.cart;

/**
 * 顾客访问商品，关心质量
 */
public class Customer extends Visitor {
    @Override
    public void visit(Book book) {
        System.out.println("顾客关注品质：" + book.getName() + "\t" + book.getQuality());
    }

    @Override
    public void visit(Apple apple) {
        System.out.println("顾客关注品质：" + apple.getName() + "\t" + apple.getQuality());
    }
}
