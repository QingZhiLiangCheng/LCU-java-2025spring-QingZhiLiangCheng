package cn.edu.lcu.cs.designpattern.iterator.container;

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
        return cursor < size;
    }

    @Override
    public E next() {
        return (E) elements[cursor++];
    }

    @Override
    public E remove() {
        E e = null;
        if (cursor < size) {
            e = (E) elements[cursor];
            // 后续元素依次前移
            for (int i = cursor; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
        return e;
    }

}
