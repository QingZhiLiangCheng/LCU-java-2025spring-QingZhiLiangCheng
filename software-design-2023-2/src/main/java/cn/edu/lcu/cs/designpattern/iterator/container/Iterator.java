package cn.edu.lcu.cs.designpattern.iterator.container;

public interface Iterator<E> {
    /**
     * @return 是否还有未被迭代的元素
     */
    boolean hasNext();

    /**
     * @return 下一个迭代元素
     */
    E next();

    /**
     * 移除当前迭代元素
     *
     * @return 被移除的元素
     */
    E remove();
}
