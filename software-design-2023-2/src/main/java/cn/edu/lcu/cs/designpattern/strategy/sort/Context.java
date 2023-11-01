package cn.edu.lcu.cs.designpattern.strategy.sort;

import lombok.Data;

/**
 * 策略模式上下文环境类，持有具体的策略对象。
 * 在策略模式中，此类不是必须的。
 * 通过环境类，可以将各种具体算法的操作统一管理，如日志输出、性能测试等。
 */
@Data
public class Context {
    private Sorting sorting;

    public Context(Sorting sorting) {
        this.sorting = sorting;
    }

    /**
     * 调用某个排序算法进行排序，并统一进行性能测试。
     *
     * @param array 待排序的数组，由Context类传递给策略类。
     * @return 排序后的数组
     */
    public int[] sort(int[] array) {
        long begin = System.nanoTime(); // 算法执行前时刻
        sorting.sort(array); // 执行算法
        long end = System.nanoTime(); // 算法执行后时刻
        long naros = end - begin; // 开始与结束之间流逝的纳秒数
        System.out.println("排序算法【" + sorting.getClass().getSimpleName() + "】运行时间（纳秒）：" + naros);
        return array;
    }

}
