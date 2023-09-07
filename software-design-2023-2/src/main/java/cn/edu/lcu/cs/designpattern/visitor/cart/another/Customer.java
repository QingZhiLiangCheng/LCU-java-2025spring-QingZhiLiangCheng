package cn.edu.lcu.cs.designpattern.visitor.cart.another;

/**
 * 顾客访问商品，关心商品的质量。
 * 商品不同，质量的衡量标准不同。
 */
public class Customer extends Visitor {
    @Override
    public void visit(Book book) {
        switch (book.getName()) {
            case "软件设计模式":
                book.setQuality("真是一本烂书！");
                break;
            case "大话设计模式":
                book.setQuality("奇书一部！");
                break;
            default:
                book.setQuality("质量一般");
        }
        System.out.println("顾客关注品质：" + book.getName() + "\t" + book.getQuality());
    }

    @Override
    public void visit(Apple apple) {
        switch (apple.getName()) {
            case "红富士":
                apple.setQuality("爽脆酸甜，好吃不贵。");
                break;
            case "蛇果":
                apple.setQuality("难吃死贵，差评！");
                break;
            default:
                apple.setQuality("质量一般");
        }
        System.out.println("顾客关注品质：" + apple.getName() + "\t" + apple.getQuality());
    }
}
