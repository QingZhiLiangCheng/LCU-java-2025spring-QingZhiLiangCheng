package cn.edu.lcu.cs.designpattern.visitor.score;

import cn.edu.lcu.cs.designpattern.visitor.score.Score;
import cn.edu.lcu.cs.designpattern.visitor.score.ScoreDB;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScoreDBTest {

    @Test
    void findAll() {
        ScoreDB scoreDB = new ScoreDB();
        List<Score> scores = scoreDB.findAll();
        scores.forEach(System.out::println);
    }
}