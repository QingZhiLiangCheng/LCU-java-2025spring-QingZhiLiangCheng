package cn.edu.lcu.cs.design_pattern.strategy.sort.util;

/**
 * @Author Ling
 * @Date 2021/10/25 20:00
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        int[] ints = {1, 3, -3, -4, 6, 2};

        int[] sorted = SortingUtil.bubbleSort(ints);
    }
}
