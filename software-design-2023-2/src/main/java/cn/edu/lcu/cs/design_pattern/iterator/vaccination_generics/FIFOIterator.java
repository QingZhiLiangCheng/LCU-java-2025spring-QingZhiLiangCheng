package cn.edu.lcu.cs.design_pattern.iterator.vaccination_generics;

import java.util.List;

/**
 * @Description 先进先出迭代器
 * @Author Ling
 * @Date 2021/9/30 0:14
 * @Version 1.0
 */
public class FIFOIterator<T> implements Iterator {
    /**
     * 被迭代的容器对象。
     * 在迭代过程中最好不要修改这个对象。
     * 仅通过构造方法注入容器，不再提供setter方法注入。
     */
    private List<T> list;
    /**
     * 游标，预迭代元素的索引，-1表示无效
     */
    private int cursor;

    /**
     * 构造迭代器对象时，注入被迭代的容器。
     * 因为本类中没有给list赋值的方法，一旦注入容器，容器就不变了。
     *
     * @param list
     */
    public FIFOIterator(List<T> list) {
        // 保存容器对象的引用
        this.list = list;
        // 判断容器是否为空
        if (list == null || list.isEmpty()) {
            // 如果是空容器，将游标设置为无效的下标-1
            cursor = -1;
        } else {
            // 如果容器有数据，将游标指向首个元素
            cursor = 0;
        }
    }

    @Override
    public boolean hasNext() {
        if (cursor >= 0 && cursor < list.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        // 返回下个未迭代的对象，并修改游标指向下个元素
        // 只读的操作，不要修改容器，比如从容器中删除当前元素是被禁止的
        return list.get(cursor++);
    }
}
