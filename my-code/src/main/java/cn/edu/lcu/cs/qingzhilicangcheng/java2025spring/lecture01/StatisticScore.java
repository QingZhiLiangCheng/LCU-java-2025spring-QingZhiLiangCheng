package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture01;

import java.util.Scanner;

/**
 * 从控制台循环读取41个Java课程的成绩，成绩为0-100之间的整数，如果成绩非法，输入提前结束。
 * 统计各分数段的人数。优、良、中、及格、不及格。
 * 结果打印到控制台。
 */
public class StatisticScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //100-90 90-80 80-70 70-60 <60
        int[] grades = new int[5];
        for (int i = 0; i < 5; i++) {
            int score = scanner.nextInt();
            if (score < 0 || score > 100) {
                throw new IllegalArgumentException("invaild score:" + score);
            }
            if (score >= 70 && score < 80) {
                grades[2]++;
            } else if (score >= 80 && score < 90) {
                grades[1]++;
            } else if (score >= 60 && score < 70) {
                grades[3]++;
            }else if(score <60){
                grades[4]++;
            }else{
                grades[0]++;
            }
        }


        for(int i=0;i<5;i++){
            System.out.println(grades[i]);
        }
    }
}
