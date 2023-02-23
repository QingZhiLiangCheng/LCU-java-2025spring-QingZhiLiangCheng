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
        int score = scanner.nextInt();
        System.out.println("score = " + score);
    }
}
