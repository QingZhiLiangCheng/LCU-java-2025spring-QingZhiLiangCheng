package cn.edu.lcu.cs.javaprogramming.basic;

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


        System.out.println("----------------------------------------------");
        System.out.println("gradeA = " + gradeA);
        System.out.println("gradeB = " + gradeB);
        System.out.println("gradeC = " + gradeC);
        System.out.println("gradeD = " + gradeD);
        System.out.println("gradeE = " + gradeE);

    }
}
