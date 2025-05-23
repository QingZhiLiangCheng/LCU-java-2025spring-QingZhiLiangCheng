package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;


/**
 * 函数式接口，用于定义执行操作的契约。
 * @param <T> 执行方法接收的参数类型
 */
@FunctionalInterface
public interface Executor<T> {

    /**
     * 执行指定的操作。
     * @param t 需要被执行操作的对象
     */
    void execute(T t);
}
