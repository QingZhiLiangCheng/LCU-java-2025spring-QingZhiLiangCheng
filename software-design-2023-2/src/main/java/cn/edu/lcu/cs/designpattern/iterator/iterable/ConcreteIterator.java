package cn.edu.lcu.cs.designpattern.iterator.iterable;

import java.util.Iterator;

public class ConcreteIterator<E> implements Iterator<E> {
    private int cursor = 0; // 游标，当前迭代元素的位置索引
    private Object[] elements;  // 容器容纳的元素列表，用数组实现
    private int size = 0;

    public ConcreteIterator(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        if (elements != null && size > 0 && cursor < size) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E next() {
        return (E) elements[cursor++];
    }

    @Override
    public void remove() {
        // TODO: 2020/10/6 未完，待续 
    }
}
