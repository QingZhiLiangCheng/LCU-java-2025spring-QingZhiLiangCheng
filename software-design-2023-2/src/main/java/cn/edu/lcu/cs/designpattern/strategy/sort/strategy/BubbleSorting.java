package cn.edu.lcu.cs.designpattern.strategy.sort.strategy;

public class BubbleSorting implements Sorting {
    @Override
    public int[] sort(int[] array) {
        for (int i = array.length; --i >= 0; )
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        return array;
    }
}
