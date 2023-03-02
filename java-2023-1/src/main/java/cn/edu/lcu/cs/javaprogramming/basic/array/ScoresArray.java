package cn.edu.lcu.cs.javaprogramming.basic.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 成绩数组演示
 * 2022/2/26 23:38
 *
 * @Author ling
 */
public class ScoresArray {

    public static void main(String[] args) {
        // 声明字符串数组并赋值，存储3、4班的班级名称
        String[] classes = {"5班", "6班"};
        //String class ="3班";

        // 遍历打印各班的名称
        for (String clazz : classes) {
            System.out.println(clazz);
        }

        // 获取随机生成的成绩数组
        // Java中数组都是对象
        int[] scores = generateScores(78);

        // 输出打印
        //print(scores);
        // Arrays 是个工具类，专门用于操作数组

        //打印原始的成绩
        System.out.println(Arrays.toString(scores));

        //    打印排序后的成绩
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));

    }

    /**
     * 随机生成若干个[0, 100]之间的整数，作为成绩，存储在数组中返回。
     *
     * @param length 数组长度
     * @return 成绩数组
     */
    public static int[] generateScores(int length) {
        // 创建length个元素的整数数组
        int[] scores = new int[length];

        // 遍历这个数组，依次用生成的随机数为数组元素赋值
        for (int i = 0; i < length; i++) {
            scores[i] = generateScore();
        }

        // 返回成绩数组
        return scores;
    }

    /**
     * 随机生成[0, 100]之间的整数，作为成绩返回。
     * 暂时不必纠结细节，直接调用即可。
     *
     * @return 随机生成的成绩
     */
    public static int generateScore() {
        Random random = new Random();
        int score = random.nextInt(101);
        return score;
    }

    /**
     * 打印数组
     *
     * @param array
     */
    public static void print(int[] array) {
        // 代码填空

        //foreach 遍历一个容器中的所有元素，遍历过程中不能修改容器的结构
        //array.iter  iterate
        for (int item : array) {
            //System.out.println(item);
            System.out.print("\t" + item);
        }

        //for (int i = 0; i < array.length; i++) {
        //    System.out.println(array[i]);
        //}

    }
}