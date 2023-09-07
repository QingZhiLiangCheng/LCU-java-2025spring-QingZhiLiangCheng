package cn.edu.lcu.cs.designpattern.strategy.score.experiment;

import lombok.Getter;
import lombok.Setter;

/**
 * 成绩类
 */
@Getter
@Setter
public class Score {
    private String studentNo;
    private String studentName;
    private String courseName;
    private Integer ordinaryScore; // 平时成绩
    private Integer experimentScore; // 实验成绩
    private Integer midtermScore; // 期中成绩
    private Integer termScore; // 期末成绩
    /**
     * 某门课程最终成绩，可能由平时成绩、实验成绩、期中成绩、期末成绩等构成。
     */
    private Double score;

    public Score(String studentNo, String studentName, String courseName, Integer ordinaryScore, Integer midtermScore, Integer termScore, Integer experimentScore) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.courseName = courseName;
        this.ordinaryScore = ordinaryScore;
        this.midtermScore = midtermScore;
        this.termScore = termScore;
        this.experimentScore = experimentScore;
    }

    /**
     * @return 总成绩构成：平时成绩10%   期中成绩20%  期末成绩40%  实验成绩30%。
     */
    public Double getScore() {
        return getOrdinaryScore() * 0.1 + getMidtermScore() * 0.2 + getTermScore() * 0.4 + experimentScore * 0.3;
    }
}
