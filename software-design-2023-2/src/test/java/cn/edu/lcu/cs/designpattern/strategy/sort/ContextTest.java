package cn.edu.lcu.cs.designpattern.strategy.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ContextTest {
    private int[] nums;

    @Test
    void bubbleSorting() {
        // 创建具体策略对象与上下文环境类，并绑定
        Context context = new Context(new BubbleSorting());
        // 策略模式环境对象提供一个统一的调用具体策略的接口。
        context.sort(nums);
    }

    @Test
    void insertSorting() {
        Context context = new Context(new InsertSorting());
        context.sort(nums);
    }

    @BeforeEach
    void beforeEach() {
        nums = new int[]{3, 2, 1, -3};
        System.out.println("排序前：\t" + Arrays.toString(nums));
    }

    @AfterEach
    void afterEach() {
        System.out.println("排序后：\t" + Arrays.toString(nums));
    }
}
