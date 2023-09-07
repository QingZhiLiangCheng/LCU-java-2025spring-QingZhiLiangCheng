package cn.edu.lcu.cs.designpattern.composite.safety;

/**
 * 叶结点
 */
public class Leaf extends Node {
    public Leaf() {
    }

    public Leaf(String value) {
        setValue(value);
    }

    @Override
    public void print() {
        // 打印若干个前导缩进符号
        System.out.print("-".repeat(getLevel()));
        System.out.println("叶子结点【" + getValue() + "】");
    }

    @Override
    public void traversal() {
        // 叶子节点，没有孩子，只能只打印自己的值。
        this.print();
    }
}
