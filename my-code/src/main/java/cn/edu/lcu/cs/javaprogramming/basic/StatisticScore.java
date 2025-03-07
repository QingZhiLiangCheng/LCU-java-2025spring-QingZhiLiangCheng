package cn.edu.lcu.cs.javaprogramming.basic;

import java.util.Scanner;

/**
 * 从控制台循环读取41个Java课程的成绩，成绩为0-100之间的整数，如果成绩非法，输入提前结束。
 * 统计各分数段的人数。优、良、中、及格、不及格。
 * 结果打印到控制台。
 */
public class StatisticScore {
    /**
     * psvm
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        声明各等级的人数
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeE = 0;

        // 41.for
        for (int i = 0; i < 4; i++) {
            int score = scanner.nextInt();
            // 对成绩做判断，给5个等级的变量赋值

            // 如果成绩非法，直接转下一轮循环
            // (score < 0 || score > 100).if
            if (score < 0 || score > 100) {
                continue;
            }
            if (score < 60) gradeE++;
            else if (score < 70) {
                gradeD++;
            } else if (score < 80) {
                gradeC++;
            } else if (score < 90) {
                gradeB++;
            } else {
                gradeA++;
            }

            // TODO：用Switch实现
        }

        System.out.println("gradeA = " + gradeA);
        System.out.println("gradeB = " + gradeB);
        System.out.println("gradeC = " + gradeC);
        System.out.println("gradeD = " + gradeD);
        System.out.println("gradeE = " + gradeE);
//        System.out.println(score);
    }
}
