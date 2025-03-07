package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture02;

import java.util.Scanner;

/**
 * 从控制台循环读取41个Java课程的成绩，成绩为0-100之间的整数，如果成绩非法，输入提前结束。
 * 统计各分数段的人数。优、良、中、及格、不及格。
 * 结果打印到控制台。
 */
public class StatisticScoreSwitch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //100-90 90-80 80-70 70-60 <60
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeE = 0;
        int score;
        for (int i = 0; i < 5; i++) {
            score = scanner.nextInt();
            if (score < 0 || score > 100) {
                throw new ArithmeticException("score不合法");
            }
/*            switch (score / 10) {
                case 10:
                case 9:
                    gradeA++;
                    break;
                case 8:
                    gradeB++;
                    break;
                case 7:
                    gradeC++;
                    break;
                case 6:
                    gradeD++;
                    break;
                default:
                    gradeE++;
                    break;
            }*/

            //新语法  --  更简洁了
            switch (score / 10) {
                case 10, 9 -> gradeA++;
                case 8 -> gradeB++;
                case 7 -> gradeC++;
                case 6 -> gradeD++;
                default -> gradeE++;
            }
        }
        System.out.println(gradeA);
    }
}
