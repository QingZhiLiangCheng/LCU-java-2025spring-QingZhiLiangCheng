package cn.edu.lcu.cs.designpattern.visitor.score;

import lombok.Data;
import lombok.ToString;

/**
 * 设计模式课程的成绩
 */
@Data
@ToString(callSuper = true)
public class DesignPatternScore extends Score {
    private Integer experimentScore; // 实验成绩

    public DesignPatternScore(String studentNo, String studentName, String courseName, Integer ordinaryScore, Integer midtermScore, Integer termScore, Integer experimentScore) {
        super(studentNo, studentName, courseName, ordinaryScore, midtermScore, termScore);
        this.experimentScore = experimentScore;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
