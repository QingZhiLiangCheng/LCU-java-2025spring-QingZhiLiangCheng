package cn.edu.lcu.cs.designpattern.strategy.score;

import org.junit.jupiter.api.Test;

import java.util.List;

class ScoreDBTest {

    @Test
    void findAll() {
        List<Score> scores = new ScoreDB().findAll();
        scores.forEach(System.out::println);
    }

}