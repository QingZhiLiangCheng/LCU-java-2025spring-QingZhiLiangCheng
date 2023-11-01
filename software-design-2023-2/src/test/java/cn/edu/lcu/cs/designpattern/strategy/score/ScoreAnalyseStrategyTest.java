package cn.edu.lcu.cs.designpattern.strategy.score;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScoreAnalyseStrategyTest {
    private static List<Score> scores;

    /**
     * 在所有测试方法之前执行，需是静态方法。
     */
    @BeforeAll
    static void beforeAll() {
        scores = new ScoreDB().findAll();
        System.out.println("--------------------原始成绩单-----------------");
        System.out.println(scores);
    }

    /**
     * 在每个测试方法之前运行。
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("---------------华丽分隔线-----------------");
    }

    /**
     * 分析期末成绩
     */
    @Test
    void analyseTermScore() {
        ScoreAnalyseStrategy analyseStrategy = new TermScoreAnalyseStrategy(scores);
        analyseStrategy.analyse();
        System.out.println(analyseStrategy);
    }

    /**
     * 分析实验成绩
     */
    @Test
    void analyseExperimentScore() {
        ScoreAnalyseStrategy analyseStrategy = new ExperimentScoreAnalyseStrategy(scores);
        analyseStrategy.analyse();
        System.out.println(analyseStrategy);
    }


}