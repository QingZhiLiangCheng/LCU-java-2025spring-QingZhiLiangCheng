package cn.edu.lcu.cs.designpattern.composite.safety;

import lombok.Getter;
import lombok.Setter;

/**
 * 安全的组合模式，与透明模式相对
 */
@Getter
@Setter
public abstract class Node {
    private String value;
    private Node parent; // 父节点

    /**
     * 所有节点共有的行为
     */
    public void commonOperation() {
        System.out.println("叶子与分枝结点共同拥有的某些操作");
    }

    /**
     * 遍历节点及所有后代节点。无论是树枝还是叶子，形式上一致。
     */
    public abstract void traversal();

    /**
     * 打印当前节点的值
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
}
