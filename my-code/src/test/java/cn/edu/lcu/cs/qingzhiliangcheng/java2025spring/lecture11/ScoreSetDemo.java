package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture11;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class ScoreSetDemo {
    private Set<Score> scores = new TreeSet<>();

    @Test
    void initialize() {
        // treeset 是有序的集合，元素必须实现 java.lang.Comparable 接口
        scores.addAll(ScoreSet.getScores());
        scores.forEach(System.out::println);
    }
}
