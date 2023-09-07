package cn.edu.lcu.cs.designpattern.iterator.container;

public class ReverseIterator<E> implements Iterator<E> {
    private int cursor = 0;
    private Object[] elements;  // 容器容纳的元素列表，用数组实现
    private int size = 0;
    public ReverseIterator(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
        this.cursor = size -1;
    }
    @Override public boolean hasNext() {
        if (size > 0 && cursor >= 0) {
            return true;
        } else return false;
    }
    @Override public E next() {
        return (E) elements[cursor--];
    }
    @Override public E remove() {
        return null;
    }
}
