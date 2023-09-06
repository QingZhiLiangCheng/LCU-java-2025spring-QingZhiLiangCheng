package cn.edu.lcu.cs.design_pattern.composite.safety;

import java.util.ArrayList;
import java.util.List;

/**
 * 分支结点
 */
public class Branch extends Node {
    private List<Node> children = new ArrayList<>();

    public Branch() {
    }

    public Branch(String value) {
        setValue(value);
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void print() {
        // 重复打印若干个前导缩进符号
        System.out.print("+".repeat(getLevel()));
        System.out.println("分枝结点【" + getValue() + "】");
    }

    /**
     * 添加孩子（独立结点或子树）。
     * 如果是子树，需要迭代子树所有结点，每个结点的级别都要加一。
     * todo 这种迭代操作在树中很常见，可引申出迭代器模式
     *
     * @param child 孩子结点，也可能是子树
     */
    public void add(Node child) {
        // 这样做有缺陷吗？？？
        // 设置孩子的级别，比当前结点级别大一个数。
        // child.setLevel(this.getLevel() + 1);
        child.setParent(this);
        this.children.add(child);
    }

    /**
     * 删除孩子，及孩子的所有后代
     *
     * @param child
     */
    public void removeChild(Node child) {
        // 直接删除孩子，这是不够的，还要删除孩子的所有后代。
        // this.children.remove(child);

        // 如果孩子是分支结点，而且有孩子，递归删除孩子的孩子
        if (child instanceof Branch && !((Branch) child).getChildren().isEmpty()) {
            Branch branch = (Branch) child;
            List<Node> grandChildren = branch.getChildren();
            int size = grandChildren.size();
            for (int i = 0; i < size; i++) {
                branch.removeChild(grandChildren.get(0));
            }
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
    public Node getChild(int index) {
        if (index >= 0 && index < this.children.size()) {
            return this.children.get(index);
        } else {
            return null;
        }
    }

    /**
     * 树枝节点，打印自己及所有后代节点的值
     */
    @Override
    public void traversal() {
        // 先打印本结点
        print();
        // 再遍历打印所有孩子结点
        for (Node node : children) {
            node.traversal();
        }
//        children.forEach(Node::traversal); // Lambda表达式更简洁
    }
}
