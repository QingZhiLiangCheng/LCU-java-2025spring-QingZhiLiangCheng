package cn.edu.lcu.cs.program_principle;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列演示依赖倒置原则：面向接口编程
 *
 * @author Ling
 */
class QueueDemo {

    /**
     * 面向接口编程演示
     */
    @Test
    public void dipDemo() {
        // 变量声明为抽象类型
        Queue<Integer> queue;
        // 用具体类的实例为其赋值
        queue = new LinkedList<>();

        // 因为变量类型是抽象类型，后续的代码只依赖于这个抽象，不会依赖具体类，更新维护比较方便
        queue.offer(1); // 进队列（队尾），若空间不足，抛出异常
        queue.add(2); // 进队列，若空间不足，仅返回false，不抛异常

        queue.peek(); // 查询队首元素，若队列空，返回null，不抛异常
        queue.element(); // 查询队首元素，若队列空，抛异常

        queue.poll(); // 出队列（队首），若队列空，仅返回null，不抛异常
        queue.remove(); // 出队列，若队列空，抛异常

        // 建议使用 offer peek poll
    }

    /**
     * 面向具体编程演示
     */
    @Test
    public void classicDemo() {
        // 变量声明为具体类型
        LinkedList<Integer> queue;
        // 用具体类的实例为其赋值
        queue = new LinkedList<>();

        // 因为变量类型是具体类型，抽象与具体的方法都可调用
        queue.offer(1); // 进队列（队尾），若空间不足，抛出异常
        queue.add(2); // 进队列，若空间不足，仅返回false，不抛异常

        queue.peek(); // 查询队首元素，若队列空，返回null，不抛异常
        queue.element(); // 查询队首元素，若队列空，抛异常

        queue.poll(); // 出队列（队首），若队列空，仅返回null，不抛异常
        queue.remove(); // 出队列，若队列空，抛异常

        // 因为变量是具体类型，除了抽象中定义的方法之外，具体类中定义的方法也可调用
        // addFirst()是LinkedList中定义的操作，但不是单端队列Queue中的操作
        // 没有任何的语法错误提示，但是单端队列队首不能插入元素，这是逻辑错误，不容易排查
        queue.addFirst(2);

        // 建议使用 offer peek poll
    }


}
