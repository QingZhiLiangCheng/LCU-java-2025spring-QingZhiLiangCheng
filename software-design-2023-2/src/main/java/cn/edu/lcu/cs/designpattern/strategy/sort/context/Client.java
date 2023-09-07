package cn.edu.lcu.cs.designpattern.strategy.sort.context;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, -3};
        System.out.println("排序前：\t" + Arrays.toString(nums));

        // 创建具体策略对象
        Sorting sorting = new InsertionSorting();
        // 策略环境类与具体策略绑定
        Context context = new Context(sorting);
        // 策略模式环境对象提供一个统一的调用具体策略的接口。
        context.sort(nums);

        System.out.println("排序后：\t" + Arrays.toString(nums));
    }
}
