package cn.edu.lcu.cs.designpattern.strategy.score;

import lombok.ToString;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 期末成绩统计分析策略
 */
@ToString(callSuper = true)
public class TermScoreAnalyseStrategy extends ScoreAnalyseStrategy {

    public TermScoreAnalyseStrategy(List<Score> scores) {
        super(scores);
    }

    public TermScoreAnalyseStrategy() {
    }

    @Override
    public void analyse() {
        if (scores != null || !scores.isEmpty()) {
            // 将list转换成Score流，再转换为整型数值流，调用标准汇总分析方法，返回汇总对象。
            IntSummaryStatistics summaryStatistics = scores.stream().mapToInt(score -> score.getTermScore()).summaryStatistics();
            // 从汇总对象中可以直接获取某些统计分析数据。
            max = summaryStatistics.getMax();
            min = summaryStatistics.getMin();
            average = summaryStatistics.getAverage();
            count = (long) scores.size();
            // 过滤成绩流，保留期末成绩满足条件的元素，然后统计元素的个数。
            countOfFail = scores.stream().filter(score -> score.getTermScore() < 60).count();
            countOfExcellent = scores.stream().filter(score -> score.getTermScore() >= 90).count();
            countOfPassed = count - countOfFail;
        }
    }

}
