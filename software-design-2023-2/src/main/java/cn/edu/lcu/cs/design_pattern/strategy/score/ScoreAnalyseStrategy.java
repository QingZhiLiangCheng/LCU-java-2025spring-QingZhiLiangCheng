package cn.edu.lcu.cs.design_pattern.strategy.score;

import lombok.ToString;

import java.util.List;

/**
 * 成绩分析策略
 */
@ToString(exclude = "scores") // 仅仅为了方便输出才添加此注解，真实案例一般不需要。
public abstract class ScoreAnalyseStrategy {
    protected List<Score> scores; // 等待分析的成绩列表
    protected Double average; // 平均分
    protected Long count; // 数量
    protected Long countOfPassed; // 及格人数
    protected Long countOfFail; // 不及格人数
    protected Long countOfExcellent; // 优秀人数
    protected Integer max; // 最高分
    protected Integer min; // 最低分

    public ScoreAnalyseStrategy() {
    }

    public ScoreAnalyseStrategy(List<Score> scores) {
        this.scores = scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Double getAverage() {
        return average;
    }

    public Long getCount() {
        return count;
    }

    public Long getCountOfPassed() {
        return countOfPassed;
    }

    public Long getCountOfFail() {
        return countOfFail;
    }

    public Long getCountOfExcellent() {
        return countOfExcellent;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
    }

    /**
     * 对成绩单进行统计分析
     */
    public abstract void analyse() ;
}
