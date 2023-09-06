package cn.edu.lcu.cs.design_pattern.strategy.sort.context;

public interface Sorting {
    /**
     * 由环境类直接推送数据给策略类。
     * （也可以推送环境类自身，策略类再从环境类中获取数据。）
     *
     * @param array 需要排序的数组
     * @return
     */
    int[] sort(int[] array);
}
