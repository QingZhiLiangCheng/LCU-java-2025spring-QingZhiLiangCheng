package cn.edu.lcu.cs.designpattern.composite.transparency;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 透明的组合模式。
 * 无论叶子还是分支，表面上看所有操作都是相同的、透明的。
 */
@Getter
@Setter
@ToString
public abstract class Node {
    private String value;
    private Node parent;

    /**
     * 虽然叶子节点没有孩子，但是为了透明化，仍然在此处定义了获取孩子的方法，可能是不安全的。
     *
     * @return
     */
    public abstract List<Node> getChildren();

    /**
     * 添加孩子（独立结点或子树）
     * 如果是子树，需要迭代子树所有结点，每个结点的级别都要加一。
     * todo 这种迭代操作在树中很常见，可引申出迭代器模式
     *
     * @param child 孩子结点，也可能是子树
     */
    public abstract void add(Node child);

    /**
     * 删除孩子及孩子的所有后代
     *
     * @param child
     */
    public abstract void removeChild(Node child);

    public abstract Node getChild(int index);

    /**
     * 按级别缩进打印当前结点内容
     */
    public abstract void print();

    /**
     * 获取当前结点的级别，根结点的级别为0。
     * 无论是叶子还是分支，这个操作都是相同的。
     *
     * @return 当前结点的级别
     */
    public int getLevel() {
        int level = 0;
        Node parent = this.parent;
        while (parent != null) {
            level++;
            parent = parent.parent;
        }
        return level;
    }

    /**
     * 所有结点通用的行为
     */
    public void commonOperation() {
        System.out.println("叶子与分枝结点共同拥有的某些操作");
    }

    /**
     * 遍历打印以结点起始的子树
     */
    public abstract void traversal();
}
