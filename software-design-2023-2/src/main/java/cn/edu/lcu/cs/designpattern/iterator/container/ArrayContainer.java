package cn.edu.lcu.cs.designpattern.iterator.container;

/**
 * 用数组实现的容器类
 *
 * @param <E>
 */
public class ArrayContainer<E> implements Container<E> {
    private int capacity = 100; // 容器可容纳元素的数量，初始为100个元素
    private int size = 0; // 容器实际容纳的元素数量
    private Object[] elements;  // 容器容纳的元素列表，用数组实现

    public ArrayContainer() {
        elements = new Object[capacity];
    }

    public ArrayContainer(int capacity) {
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
    public E get(int index) {
        if (index >= 0 && index < size) {
            return (E) elements[index];
        } else {
            return null;
        }
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e == elements[i]) {
                return i;
            }
        }
        return -1;
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
        int index = indexOf(e);
        // 如果查询到该元素，将其后所有元素依次前移。
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(this.elements, this.size);
    }

    @Override
    public Iterator<E> reverseIterator() {
        return new ReverseIterator<>(this.elements, this.size);
    }
}
