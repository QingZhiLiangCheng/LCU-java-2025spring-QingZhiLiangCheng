package cn.edu.lcu.cs.designpattern.composite.transparency;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        // 随机构造一棵树，可能比较复杂，可能仅一片叶子而已，都不影响后续的操作。
        Node tree = buildTree();
        // 调用树枝与叶子都具有的公共操作
        tree.commonOperation();
        // 遍历这棵树，带分支的树与仅一片叶子的极简树的遍历在形式上无差别，在实质上有区别，这就是多态。
        System.out.println("---------树的遍历------------");
        tree.traversal();

        // 别管 tree 是叶子还是分支，反正在表象上操作是一致透明的
        // 所以不必再先判断类型，再强转为分支了。
        Node child = tree.getChild(0);
        if (child != null) {
            System.out.println("---------树的分支-----------");
            child.traversal();

            System.out.println("---------删除分支----------");
            // 客户端不必区别叶子与分支，代码很优雅
            tree.removeChild(child);
            tree.traversal();
        }
    }

    /**
     * 随机构造一棵复杂树，或者仅一片叶子的极简树。
     *
     * @return
     */
    private static Node buildTree() {
        int rand = new Random().nextInt(2);
        if (rand == 0) {
            Node tree = new Branch("根结点");

            Node branch = new Branch("分枝结点1");
            branch.add(new Leaf("叶子结点11"));
            branch.add(new Leaf("叶子结点12"));
            branch.add(new Leaf("叶子结点13"));
            tree.add(branch);

            Node branch2 = new Branch("分枝结点2");
            branch2.add(new Leaf("叶子结点21"));
            branch2.add(new Leaf("叶子结点22"));
            branch2.add(new Leaf("叶子结点23"));
            tree.add(branch2);

            Branch branch24 = new Branch("分枝结点24");
            branch24.add(new Branch("分枝结点241"));
            branch24.add(new Leaf("分枝结点242"));
            branch2.add(branch24);

            return tree;
        } else {
            return new Leaf("一片孤独的叶子");
        }
    }
}
