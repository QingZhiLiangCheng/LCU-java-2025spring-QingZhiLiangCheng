package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

/**
 * 对两个雇员的年龄做逆向比较
 * @author Ling
 */
public class EmployeeAgeDecendComparator implements Comparator {
    /**
     *
     * @param e1 雇员1
     * @param e2 雇员2
     * @return 正数：第一个雇员年龄大；0：两者年龄相等；负数：第一个雇员年龄小
     */
    @Override
    public int compare(Employee e1, Employee e2) {
        return e2.getAge() - e1.getAge();
//        if (e1.getAge() < e2.getAge()) {
//            return -1;
//        } else if (e1.getAge() > e2.getAge()) {
//            return 1;
//        } else {
//            return 0;
//        }
    }
}
