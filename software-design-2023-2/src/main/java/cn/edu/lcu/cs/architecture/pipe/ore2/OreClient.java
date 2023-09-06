package cn.edu.lcu.cs.architecture.pipe.ore2;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.io.IOException;

import static cn.edu.lcu.cs.architecture.pipe.ore2.Ore.OreGrade.*;
import static cn.edu.lcu.cs.util.ConsoleColor.*;

public class OreClient {

    public static void main(String[] args) {
        // 创建数据源及各级管道过滤器
        Mine mine = new Mine(); // 矿井
        GradeSieve specialGradeSieve = new GradeSieve(SPECIAL, FG_BLUE); // 特级矿石筛子
        GradeSieve gradeOneSieve = new GradeSieve(GRADE_ONE, FG_CYAN); // 一级矿石筛子
        GradeSieve gradeTwoSieve = new GradeSieve(GRADE_TWO, FG_GREEN); // 二级矿石筛子
        GradeSieve ungradedSieve = new GradeSieve(UNGRADED, FG_PURPLE); // 次品矿石筛子
        SpoilYard spoilYard = new SpoilYard(WASTE, FG_RED); // 废料场
        try {
            // 分别将上游过滤器管道输出流与下游过滤器的管道输入流连接起来
            mine.getPipedOutputStream().connect(specialGradeSieve.getPipedInputStream());
            specialGradeSieve.getPipedOutputStream().connect(gradeOneSieve.getPipedInputStream());
            gradeOneSieve.getPipedOutputStream().connect(gradeTwoSieve.getPipedInputStream());
            gradeTwoSieve.getPipedOutputStream().connect(ungradedSieve.getPipedInputStream());
            ungradedSieve.getPipedOutputStream().connect(spoilYard.getPipedInputStream());
            // 启动各个过滤器线程，持续生产矿石并输送到管道中的各级过滤器上
            mine.start();
            specialGradeSieve.start();
            gradeOneSieve.start();
            gradeTwoSieve.start();
            ungradedSieve.start();
            spoilYard.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
