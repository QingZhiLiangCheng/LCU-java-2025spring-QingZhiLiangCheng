package cn.edu.lcu.cs.design_pattern.strategy.score;

import java.util.List;

/**
 * 成绩统计分析环境类
 */
public class ScoreAnalyseContext {
    private List<Score> scores;
    private ScoreAnalyseStrategy analyseStrategy;

    public void setAnalyseStrategy(ScoreAnalyseStrategy analyseStrategy) {
        this.analyseStrategy = analyseStrategy;
        analyseStrategy.setScores(scores);
    }

    public ScoreAnalyseContext(List<Score> scores) {
        this.scores = scores;
    }

    public void analyse() {
        analyseStrategy.analyse();
    }

    public Double getAverage() {
        return analyseStrategy.getAverage();
    }

    public Long getCount() {
        return analyseStrategy.getCount();
    }

    public Long getCountOfPassed() {
        return analyseStrategy.getCountOfPassed();
    }

    public Long getCountOfFail() {
        return analyseStrategy.getCountOfFail();
    }

    public Long getCountOfExcellent() {
        return analyseStrategy.getCountOfExcellent();
    }

    public Integer getMax() {
        return analyseStrategy.getMax();
    }

    public Integer getMin() {
        return analyseStrategy.getMin();
    }

}
