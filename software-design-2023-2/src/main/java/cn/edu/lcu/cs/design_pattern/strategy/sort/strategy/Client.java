package cn.edu.lcu.cs.design_pattern.strategy.sort.strategy;

import java.util.Arrays;

/**
 * 若想对所有算法进行统一处理，
 * 如运行效率计算、日志管理等，
 * 此种设计需要客户端分散操作，
 * 不方便统一管理。
 */
public class Client {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, -3};
        System.out.println("排序前：\t" + Arrays.toString(nums));

        Sorting sorting = new BubbleSorting();

        // 统计此算法的执行耗时
        long begin = System.nanoTime();
        sorting.sort(nums);
        long end = System.nanoTime();
        System.out.println("算法运行耗费了 " + (end - begin) + " 纳秒");

        System.out.println("排序后：\t" + Arrays.toString(nums));
    }
}
