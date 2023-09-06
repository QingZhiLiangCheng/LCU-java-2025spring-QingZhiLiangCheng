package cn.edu.lcu.cs.design_pattern.iterator.iterable;

/**
 * 聚合类接口，继承自JDK类库中的Iterable接口
 *
 * @param <E>
 */
public interface Aggregate<E> extends Iterable<E> {
    /**
     * @return 容器中元素个数
     */
    int size();

    boolean isEmpty();

    boolean contains(E e);

    void add(E e);

    void remove(E e);
}
