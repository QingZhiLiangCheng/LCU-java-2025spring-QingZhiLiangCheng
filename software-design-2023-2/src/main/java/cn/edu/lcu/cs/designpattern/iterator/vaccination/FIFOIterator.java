package cn.edu.lcu.cs.designpattern.iterator.vaccination;

import java.util.List;

/**
 * @Description 先进先出迭代器
 * @Author Ling
 * @Date 2021/9/30 0:14
 * @Version 1.0
 */
public class FIFOIterator implements Iterator {
    /**
     * 被迭代的容器对象。
     * 在迭代过程中最好不要修改这个对象。
     * 仅通过构造方法注入容器，不再提供setter方法注入。
     */
    private List<Person> people;
    /**
     * 游标，预迭代元素的索引，-1表示无效
     */
    private int cursor;

    /**
     * 构造迭代器对象时，注入被迭代的容器。
     * 因为本类中没有给people赋值的方法，一旦注入容器，容器就不变了。
     *
     * @param people
     */
    public FIFOIterator(List<Person> people) {
        // 保存容器对象的引用
        this.people = people;
        // 判断容器是否为空
        if (people == null || people.isEmpty()) {
            // 如果是空容器，将游标设置为无效的下标-1
            cursor = -1;
        } else {
            // 如果容器有数据，将游标指向首个元素
            cursor = 0;
        }
    }

    @Override
    public boolean hasNext() {
        if (cursor >= 0 && cursor < people.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Person next() {
        // 返回下个未迭代的对象，并修改游标指向下个元素
        // 只读的操作，不要修改容器，比如从容器中删除当前元素是被禁止的
        return people.get(cursor++);
    }
}
