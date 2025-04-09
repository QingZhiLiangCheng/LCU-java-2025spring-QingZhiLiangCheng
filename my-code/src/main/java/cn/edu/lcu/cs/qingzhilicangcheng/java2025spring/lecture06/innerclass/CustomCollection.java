package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture06.innerclass;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 内部类可以用于实现集合类的迭代器。例如，自定义一个简单的集合类，并在其内部实现迭代器接口。
 * @author ling
 * @param <T>
 */
public class CustomCollection<T> implements Iterable<T>{
    private T[] elements;
    private int size;

    public CustomCollection(int capacity) {
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        if (size < elements.length) {
            elements[size++] = element;
        } else {
            throw new IllegalStateException("Collection is full");
        }
    }

    // 内部类 IteratorImpl 实现 Iterator 接口
    private class IteratorImpl implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[currentIndex++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    public static void main(String[] args) {
        CustomCollection<String> collection = new CustomCollection<>(3);
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Cherry");

        for (String item : collection) {
            System.out.println(item);
        }
    }
}
