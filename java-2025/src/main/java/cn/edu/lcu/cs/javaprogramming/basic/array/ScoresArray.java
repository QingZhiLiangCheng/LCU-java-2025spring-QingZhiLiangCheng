package cn.edu.lcu.cs.javaprogramming.basic.array;

import java.util.Random;

/**
 * 成绩数组演示。
 * 2022/2/26 23:38
 *
 * @Author ling
 */
public class ScoresArray {

    public static void main(String[] args) {
        // 声明字符串数组并赋值，存储5、6班的班级名称

        // 遍历打印各班的名称

        // 获取随机生成的成绩数组

        // 输出打印

    }

    /**
     * 随机生成若干个[0, 100]之间的整数，作为成绩，存储在数组中返回。
     *
     * @param length 数组长度
     * @return 成绩数组
     */
    public static int[] generateScores(int length) {
        // 创建length个元素的整数数组

        // 遍历这个数组，依次用生成的随机数为数组元素赋值

        // 返回成绩数组
        return null;
    }

    /**
     * 随机生成[0, 100]之间的整数，作为成绩返回。
     * 暂时不必纠结细节，直接调用即可。
     *
     * @return 随机生成的成绩
     */
    public static int generateScore() {
        Random random = new Random();
        int score = random.nextInt(100 + 1);
        return score;
    }

    /**
     * 打印数组
     *
     * @param array
     */
    public static void print(int[] array) {
        // 代码填空

    }
}