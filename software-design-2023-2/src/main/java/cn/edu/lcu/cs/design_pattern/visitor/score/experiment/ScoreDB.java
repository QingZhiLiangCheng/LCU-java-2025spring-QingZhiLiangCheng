package cn.edu.lcu.cs.design_pattern.visitor.score.experiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 用内存中的静态列表模拟成绩数据库
 */
public class ScoreDB {
    private static List<Score> scores = new ArrayList<>();
    public final static String COURSE_NAME_JAVA = "Java面向对象编程技术";
    public final static String COURSE_NAME_DESIGN_PATTERN = "软件设计模式";

    // 静态初始化块，当类加载时初始化成绩列表
    // 此成绩单系原始成绩单，最终成绩需授课老师访问后设置。
    static {
        scores.add(new JavaScore("001", "张三", COURSE_NAME_JAVA, randomScore(), randomScore(), randomScore()));
        scores.add(new JavaScore("002", "李四", COURSE_NAME_JAVA, randomScore(), randomScore(), randomScore()));
        scores.add(new JavaScore("003", "王五", COURSE_NAME_JAVA, randomScore(), randomScore(), randomScore()));
        scores.add(new JavaScore("004", "赵六", COURSE_NAME_JAVA, randomScore(), randomScore(), randomScore()));
        scores.add(new JavaScore("005", "小七", COURSE_NAME_JAVA, randomScore(), randomScore(), randomScore()));

        scores.add(new DesignPatternScore("001", "张三", COURSE_NAME_DESIGN_PATTERN, randomScore(), randomScore(), randomScore(), randomScore()));
        scores.add(new DesignPatternScore("002", "李四", COURSE_NAME_DESIGN_PATTERN, randomScore(), randomScore(), randomScore(), randomScore()));
        scores.add(new DesignPatternScore("003", "王五", COURSE_NAME_DESIGN_PATTERN, randomScore(), randomScore(), randomScore(), randomScore()));
        scores.add(new DesignPatternScore("004", "赵六", COURSE_NAME_DESIGN_PATTERN, randomScore(), randomScore(), randomScore(), randomScore()));
        scores.add(new DesignPatternScore("005", "小七", COURSE_NAME_DESIGN_PATTERN, randomScore(), randomScore(), randomScore(), randomScore()));
    }

    public List<Score> findAll() {
        return scores;
    }

    private static int randomScore() {
        return new Random().nextInt(101);
    }
}
