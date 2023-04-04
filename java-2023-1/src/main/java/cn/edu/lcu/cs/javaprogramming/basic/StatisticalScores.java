package cn.edu.lcu.cs.javaprogramming.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StatisticalScores {

    public static void main(String[] args) {
        System.out.println("请输入0~100之间的成绩");
        //Scanner scanner = new Scanner(System.in);
        //new Scanner(System.in).var
        Scanner scanner = new Scanner(System.in);

        //scanner.nextInt().var
        //scanner.nextInt() ctrl alt v
        //int score = scanner.nextInt();
        //System.out.println("score = " + score);


        //gradeA
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeE = 0;


        //从控制台循环输入78个成绩
        //统计其中各个成绩段的人数
        //5.for
        int count = 5;
        for (int i = 0; i < count; ) {
            int score = 0;
            try {
                score = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                continue;
            }
            if (score < 0 || score > 100) {
                continue;
            }
            i++;

            //jdk 14新添加的语法
            switch (score / 10) {
                case 10, 9 -> gradeA++;
                case 8 -> gradeB++;
                case 7 -> gradeC++;
                case 6 -> gradeD++;
                default -> gradeE++;
            }

            //switch (score / 10) {
            //    case 10:
            //    case 9:
            //        gradeA++;
            //        break;
            //    case 8:
            //        gradeB++;
            //        break;
            //    case 7:
            //        gradeC++;
            //        break;
            //    case 6:
            //        gradeD++;
            //        break;
            //    default:
            //        gradeE++;
            //}


            //    判断成绩的等级
            //if (score <= 100 && score >= 90) {
            //    gradeA++;
            //} else if (score >= 80) {
            //    gradeB++;
            //} else if (score >= 70) {
            //    gradeC++;
            //} else if (score >= 60) {
            //    gradeD++;
            //} else if (score >= 0) {
            //    gradeE++;
            //}
        }


        System.out.println("----------------------------------------------");
        System.out.println("gradeA = " + gradeA);
        System.out.println("gradeB = " + gradeB);
        System.out.println("gradeC = " + gradeC);
        System.out.println("gradeD = " + gradeD);
        System.out.println("gradeE = " + gradeE);

    }
}
