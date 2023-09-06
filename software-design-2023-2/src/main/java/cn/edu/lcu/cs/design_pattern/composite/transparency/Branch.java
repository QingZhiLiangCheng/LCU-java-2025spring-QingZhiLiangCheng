package cn.edu.lcu.cs.design_pattern.composite.transparency;

import java.util.ArrayList;
import java.util.List;

/**
 * 透明组合模式的分支结点。
 */
public class Branch extends Node {
    private List<Node> children = new ArrayList<>();

    public Branch() {
    }

    public Branch(String value) {
        setValue(value);
    }

    @Override
    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void add(Node child) {
        // 这样做有缺陷吗？？？
        // 设置孩子的级别，比当前结点级别大一个数。
        // child.setLevel(this.getLevel() + 1);
        child.setParent(this);
        this.children.add(child);
    }

    /**
     * 先删除孩子的后代们，再删除孩子
     *
     * @param child
     */
    @Override
    public void removeChild(Node child) {
        // 获取孩子的孩子，即孙辈们
        List<Node> grandChildren = child.getChildren();
        // 如果孙辈们非空，递归删除他们
        if (grandChildren != null && !grandChildren.isEmpty()) {
            int size = grandChildren.size();
            for (int i = 0; i < size; i++) {
                child.removeChild(grandChildren.get(0));
            }
            // 下面的语法似乎更简洁，为什么不用呢？
            // grandChildren.forEach(node -> grandChildren.remove(node));
        }
        // 删除孩子
        this.children.remove(child);
    }

    /**
     * 根据索引获取孩子节点
     *
     * @param index 孩子节点的索引，起始于0
     * @return
     */
    @Override
    public Node getChild(int index) {
        if (index >= 0 && index < this.children.size()) {
            return this.children.get(index);
        } else {
            return null;
        }
    }

    @Override
    public void traversal() {
        // 分支先打印本结点
        print();
        // 再遍历打印所有孩子结点
        getChildren().forEach(Node::traversal);
    }

    @Override
    public void print() {
        // 重复打印若干个前导缩进符号
        System.out.print("+".repeat(getLevel()));
        System.out.println("分枝【" + getValue() + "】");
    }
}
