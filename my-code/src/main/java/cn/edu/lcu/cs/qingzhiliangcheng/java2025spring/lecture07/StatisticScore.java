package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture07;

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
//                e.printStackTrace();
                // 输出一个友好的错误提示。
                System.out.println("您输入了一个格式错误的整数");
                // 如果输入的整数格式不正确，直接转下一轮循环
                // 跳过当前错误的输入
                scanner.next();
                continue;
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

        System.out.println("gradeA = " + gradeA);
        System.out.println("gradeB = " + gradeB);
        System.out.println("gradeC = " + gradeC);
        System.out.println("gradeD = " + gradeD);
        System.out.println("gradeE = " + gradeE);
//        System.out.println(score);
    }
}
