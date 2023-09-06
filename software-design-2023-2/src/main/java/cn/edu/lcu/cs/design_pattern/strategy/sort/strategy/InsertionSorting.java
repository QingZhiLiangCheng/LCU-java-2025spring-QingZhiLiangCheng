package cn.edu.lcu.cs.design_pattern.strategy.sort.strategy;

/**
 * 策略模式的具体策略类
 */
public class InsertionSorting implements Sorting {
    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int numToBeInserted = array[i];
            while ((j > 0) && (array[j - 1] > numToBeInserted)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = numToBeInserted;
        }
        return array;
    }
}
