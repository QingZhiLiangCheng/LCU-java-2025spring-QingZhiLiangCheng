package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture03;

import cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture02.ScoresArray;

/**
 * 二维数组演示 <br>
 * 用二维数组存储5班与6班的Java成绩 <br>
 * 两个班的人数分别是40人、41人
 *
 * @author: ling
 * @since: 2022-02-28 17:08
 **/
public class TwoDimensionScoresArray {
    public static void main(String[] args) {
        // 二维数组每行元素数量可以不同，与C语言区别比较大
        // 声明2行的二维数组，列数不确定
        int[][] scores = new int[2][];
        // 调用方法，随机生成41人的成绩，返回一维整型数组，给二维数组的首行赋值
        //ScoresArray.generateScores(41);
        scores[0] = ScoresArray.generateScores(41);
        // 调用方法，随机生成43人的成绩，返回一维整型数组，给二维数组的第2行赋值
        scores[1] = ScoresArray.generateScores(43);
        // 打印二维数组
        print(scores);
    }


    /**
     * 演示二维数组的遍历 <br>
     * 打印二维数组 <br>
     * 按照行列方式打印数组内容，注意列要对齐
     *
     * @param scores
     */
    private static void print(int[][] scores) {
        // 代码填空
        for (int[] arr : scores) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }

}
