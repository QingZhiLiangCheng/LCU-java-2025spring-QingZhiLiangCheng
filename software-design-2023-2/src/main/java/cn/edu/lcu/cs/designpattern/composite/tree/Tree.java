package cn.edu.lcu.cs.designpattern.composite.tree;

import java.util.List;

/**
 * @description: 通用树的接口
 * @author: ling
 * @since: 2021-10-04 20:29
 **/
public class Tree<E> {
    /**
     * 树根结点
     */
    private Node root;

    public Tree() {
    }

    public Tree(E element) {
        root = new Node(element);
    }

    public void setRoot(E rootElement) {
        this.root = new Node(rootElement);
    }

    public boolean contains(E element) {
        return false; // todo
    }

    /**
     * 遍历树，将所有元素转换为列表返回。
     * todo 可以添加参数，指定遍历的类型：前序、后序、中序等
     *
     * @return 树中所有元素的列表
     */
    public List<E> walk() {
        return null; // todo
    }

    /**
     * 删除子树
     *
     * @param subtree 子树
     */
    public void remove(Tree<E> subtree) {

    }

    public boolean isEmpty() {
        return root == null;
    }


}
