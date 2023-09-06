package cn.edu.lcu.cs.design_pattern.composite.transparency;

import java.util.List;

/**
 * 透明的组合模式叶结点。
 * 某些方法叶子不需要，但为了透明与一致，仍然需要在类中实现。
 * 在这些方法中，可以抛出一个异常，或者返回空值，或者什么也不做。
 */
public class Leaf extends Node {
    public Leaf() {
    }

    public Leaf(String value) {
        setValue(value);
    }

    @Override
    public List<Node> getChildren() {
//        throw new RuntimeException("叶节点没有孩子节点");
        return null;
    }

    @Override
    public void add(Node child) {
//        throw new RuntimeException("叶节点无法添加孩子节点");
    }

    @Override
    public void removeChild(Node child) {
//        throw new RuntimeException("叶节点无法删除孩子节点");
    }

    @Override
    public Node getChild(int index) {
//        throw new RuntimeException("叶节点没有孩子节点");
        return null;
    }

    @Override
    public void traversal() {
        // 叶子只打印本结点
        print();
    }

    @Override
    public void print() {
        System.out.print("-".repeat(getLevel()));
        System.out.println("叶子【" + getValue() + "】");
    }
}
