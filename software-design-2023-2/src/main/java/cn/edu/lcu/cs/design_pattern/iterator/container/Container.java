package cn.edu.lcu.cs.design_pattern.iterator.container;

/**
 * 容器类，用于持有若干元素，并提供增删改查等操作。
 *
 * @param <E>
 */
public interface Container<E> {
    int size();

    boolean isEmpty();

    boolean contains(E e);

    void add(E e);

    void remove(E e);

    /**
     * 根据元素索引获取元素
     *
     * @param index 元素索引
     * @return 若找到，返回找到的元素；若找不到，返回空。
     */
    E get(int index);


    /**
     * 查找元素的位置
     *
     * @param e 待查询元素
     * @return 若找到，返回元素的索引；若找不到，返回-1。
     */
    int indexOf(E e);

    Iterator<E> iterator();

    Iterator<E> reverseIterator();
}
