package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 根据年龄比较大小，年龄小的在前边。 <br>
 * 这是具名的比较器实现类，有可能只会用到一次。 <br>
 * 如果仅用到一次，没有必要单独创建一个带名字的实现类，应该用匿名内部类实现。
 *
 * @author ling
 * @date 2022/3/22 17:19
 */
public class AgeAscendComparator implements Comparator {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getAge() - e2.getAge();
    }
}