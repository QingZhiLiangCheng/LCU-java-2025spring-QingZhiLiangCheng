package cn.edu.lcu.cs.designpattern.composite.tree;

import java.util.List;

/**
 * @description:
 * @author: ling
 * @since: 2021-10-04 21:02
 **/
class Node<E> {
    private E element;
    private Node parent;
    private List<Node> children;

    public Node(E element) {
        this.element = element;
    }
}
