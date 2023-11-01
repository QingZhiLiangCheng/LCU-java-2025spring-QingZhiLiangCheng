package cn.edu.lcu.cs.designpattern.strategy.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class InsertSortingTest {

    @Test
    void sort() {
        int[] nums = {3, 2, 1, -3};
        System.out.println("排序前：\t" + Arrays.toString(nums));

        // 创建具体策略对象
        Sorting sorting = new InsertSorting();
        sorting.sort(nums);

        System.out.println("排序后：\t" + Arrays.toString(nums));
    }
}