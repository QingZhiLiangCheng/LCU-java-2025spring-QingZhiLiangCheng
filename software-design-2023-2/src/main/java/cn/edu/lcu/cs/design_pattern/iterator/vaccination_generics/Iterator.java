package cn.edu.lcu.cs.design_pattern.iterator.vaccination_generics;

/**
 * @Description 迭代器接口
 * @Author Ling
 * @Date 2021/9/30 0:01
 * @Version 1.0
 */
public interface Iterator<T> {
    /**
     * 判断还有没有未被迭代过的对象
     *
     * @return 是否还有未迭代对象
     */
    boolean hasNext();

    /**
     * 返回下一个未被迭代过的对象。
     * 按照何种策略从众多对象中选择一个并返回，接口不关心，反正有就返回一个。
     *
     * @return 下一个未被迭代过的对象，如果找不到就返回空。
     */
    T next();
}
