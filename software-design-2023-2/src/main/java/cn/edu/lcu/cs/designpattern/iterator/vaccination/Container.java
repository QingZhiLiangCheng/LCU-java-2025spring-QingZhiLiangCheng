package cn.edu.lcu.cs.designpattern.iterator.vaccination;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 容器类，容纳被接种人
 * @Author Ling
 * @Date 2021/9/29 23:56
 * @Version 1.0
 */
public class Container {
    /**
     * 真正持有对象的数据结构。
     * 可以用现成的List Queue等，也可以用数组、链表等数据结构实现。
     */
    private List<Person> people = new ArrayList<>();

    /**
     * 返回容器的迭代器对象。
     * 可以返回固定的某种迭代器对象，也可以根据某种策略动态选择不同的迭代器对象。
     * 到底返回哪种迭代器对象，对数据消费者是透明的。
     *
     * @return 迭代器对象
     */
    public Iterator iterator() {
        // 暂定返回固定的先进先出迭代器对象
        return new FIFOIterator(this.people);
    }

    public void add(Person person) {
        people.add(person);
    }

    public void remove(Person person) {
        people.remove(person);
    }
}
