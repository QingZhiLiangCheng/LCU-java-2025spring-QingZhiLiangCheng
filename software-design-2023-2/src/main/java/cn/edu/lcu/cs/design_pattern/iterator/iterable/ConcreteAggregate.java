package cn.edu.lcu.cs.design_pattern.iterator.iterable;

import java.util.Iterator;

public class ConcreteAggregate<E> implements Aggregate<E> {
    private int capacity = 100; // 容器可容纳元素的数量，初始为100个元素
    private int size = 0; // 容器实际容纳的元素数量
    private Object[] elements;  // 容器容纳的元素列表，用数组实现

    public ConcreteAggregate() {
        elements = new Object[capacity];
    }

    public ConcreteAggregate(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        for (Object element : elements) {
            if (e == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E e) {
        if (size < capacity) {
            elements[size++] = e;
        }
    }

    @Override
    public void remove(E e) {

    }

    /**
     * 这个方法其实是个工厂方法，参见工厂方法模式。
     * 容器（产品）有很多种，每种容器都有获取其独特迭代器的工厂方法。
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.elements, this.size);
    }
}
