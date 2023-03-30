package cn.edu.lcu.cs.javaprogramming.oop.animal;

/**
 * @author Ling
 */
@FunctionalInterface
public interface Flyable {

    /**
     * 函数式接口中可以有default修饰的具体方法
     */
    default void print() {
    }

    void fly();
}
