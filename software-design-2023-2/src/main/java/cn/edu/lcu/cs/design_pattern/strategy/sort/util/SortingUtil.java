package cn.edu.lcu.cs.design_pattern.strategy.sort.util;

/**
 * 提供各种排序算法。
 * 职责分离不彻底。
 * 增删改算法时，需要重新编译。
 * 这就是一个常用的工具类。
 *
 * @Author Ling
 * @Date 2021/10/25 19:48
 * @Version 1.0
 */
public class SortingUtil {
    /**
     * 仅演示用，所以并没有真正排序。
     *
     * @param ints 原始数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] ints) {
        return ints;
    }

    /**
     * 仅演示用，所以并没有真正排序。
     *
     * @param ints 原始数组
     * @return 排序后的数组
     */
    public static int[] binarySort(int[] ints) {
        return ints;
    }

    /**
     * 仅演示用，所以并没有真正排序。
     *
     * @param ints 原始数组
     * @return 排序后的数组
     */
    public static int[] heapSort(int[] ints) {
        return ints;
    }

    /**
     * 仅演示用，所以并没有真正排序。
     *
     * @param ints 原始数组
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] ints) {
        return ints;
    }
}
