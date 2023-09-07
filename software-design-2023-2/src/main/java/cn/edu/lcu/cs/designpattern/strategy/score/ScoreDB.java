package cn.edu.lcu.cs.designpattern.strategy.score;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 用内存中的静态列表模拟成绩数据库
 */
public class ScoreDB {
    private static List<Score> scores = new ArrayList<>();
    public final static String COURSE_NAME_DESIGN_PATTERN = "软件设计模式";

    // 静态初始化块，当类加载时初始化成绩列表
    static {
        for (int i = 0; i < 79; i++) {
            String id = String.format("%02d", i);
            scores.add(new Score("s" + id, "学生" + id, COURSE_NAME_DESIGN_PATTERN, randomScore(), randomScore(), randomScore(), randomScore()));
        }
    }

    public List<Score> findAll() {
        return scores;
    }

    private static int randomScore() {
        return new Random().nextInt(101);
    }

}
