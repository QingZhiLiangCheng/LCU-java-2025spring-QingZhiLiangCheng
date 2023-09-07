package cn.edu.lcu.cs.designpattern.visitor.score.experiment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设计模式课程的成绩
 */
@Getter
@Setter
@ToString(callSuper = true)
public class DesignPatternScore extends Score {
    /**
     * 实验成绩
     */
    private Integer experimentScore;

    public DesignPatternScore(String studentNo, String studentName, String courseName, Integer ordinaryScore, Integer midtermScore, Integer termScore, Integer experimentScore) {
        super(studentNo, studentName, courseName, ordinaryScore, midtermScore, termScore);
        this.experimentScore = experimentScore;
    }

}
