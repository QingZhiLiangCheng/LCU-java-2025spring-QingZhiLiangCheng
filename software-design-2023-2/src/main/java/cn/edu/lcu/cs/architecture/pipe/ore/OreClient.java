package cn.edu.lcu.cs.architecture.pipe.ore;

import java.io.IOException;

public class OreClient {

    public static void main(String[] args) {
        // 创建数据源及各级管道过滤器
        Mine mine = new Mine(); // 矿井
        SpecialGradeSieve specialGradeSieve = new SpecialGradeSieve(); // 特级矿石筛子
        GradeOneSieve gradeOneSieve = new GradeOneSieve(); // 一级矿石筛子
        GradeTwoSieve gradeTwoSieve = new GradeTwoSieve(); // 二级矿石筛子
        UngradedSieve ungradedSieve = new UngradedSieve(); // 次品矿石筛子
        WasteYard wasteYard = new WasteYard(); // 废料场
        try {
            // 分别将上游过滤器管道输出流与下游过滤器的管道输入流连接起来
            mine.getPipedOutputStream().connect(specialGradeSieve.getPipedInputStream());
            specialGradeSieve.getPipedOutputStream().connect(gradeOneSieve.getPipedInputStream());
            gradeOneSieve.getPipedOutputStream().connect(gradeTwoSieve.getPipedInputStream());
            gradeTwoSieve.getPipedOutputStream().connect(ungradedSieve.getPipedInputStream());
            ungradedSieve.getPipedOutputStream().connect(wasteYard.getPipedInputStream());
            // 启动各个过滤器线程，持续生产矿石并输送到管道中的各级过滤器上
            mine.start();
            specialGradeSieve.start();
            gradeOneSieve.start();
            gradeTwoSieve.start();
            ungradedSieve.start();
            wasteYard.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
