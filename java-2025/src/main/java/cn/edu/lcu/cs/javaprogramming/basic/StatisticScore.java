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
     *
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

        int length = 4;
        System.out.printf("请输入%d个成绩%n", length);

        // length.for
        int i = 0;
        while (i < length) {
            // 从控制台读入一个整数成绩
            int score = 0;
            try {
                score = scanner.nextInt();
            } catch (Exception e) {
                // 捕获异常之后，要么打印栈追踪信息，要么对异常进行容错处理，严格禁止啥也不做！！！

                // 打印异常的基本信息，及异常发生时的栈追踪信息，用于调试纠错。
                //e.printStackTrace();

                // 输出一个友好的错误提示。
                System.out.println("您输入了一个格式错误的整数");

                // 跳过刚刚引发异常的格式有误的输入，以对下一个输入进行解析。
                scanner.next();

                // 跳过后续的循环体，继续下一轮输入与解析。
                continue;
            } finally {
                // 无论前边有没有异常发生，finally代码都会被执行。
                System.out.println("无论正确或错误，反正输入了一个值");
            }

            // 如果整数格式对，则对成绩做判断，给5个等级的变量赋值

            // 如果不是[0, 100]之间的成绩，直接转下一轮循环
            // (score < 0 || score > 100).if
            if (score < 0 || score > 100) {
                continue;
            }
/*
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
*/

            // 用Switch实现
            switch (score / 10) {
                case 10, 9 -> gradeA++;
                case 8 -> gradeB++;
                case 7 -> gradeC++;
                case 6 -> gradeD++;
                default -> gradeE++;
            }
/*
            switch (score / 10) {
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
            }
*/
            i++;
        }

        System.out.printf("优%d人，良%d人，中%d人，差%d人，不及格%d人", gradeA, gradeB, gradeC, gradeD, gradeE);

    }
}
