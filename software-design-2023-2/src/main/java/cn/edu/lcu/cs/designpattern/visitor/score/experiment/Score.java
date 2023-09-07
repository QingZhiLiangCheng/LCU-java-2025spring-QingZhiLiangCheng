package cn.edu.lcu.cs.designpattern.visitor.score.experiment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 成绩基类
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Score {
    private String studentNo;
    private String studentName;
    private String courseName;
    /**
     * 平时成绩
     */
    private Integer ordinaryScore;
    /**
     * 期中成绩
     */
    private Integer midtermScore;
    /**
     * 期末成绩
     */
    private Integer termScore;
    /**
     * 某门课程最终成绩，可能由平时成绩、实验成绩、期中成绩、期末成绩等构成。
     * @return
     */
    private Double totalScore;

    public Score(String studentNo, String studentName, String courseName, Integer ordinaryScore, Integer midtermScore, Integer termScore) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.courseName = courseName;
        this.ordinaryScore = ordinaryScore;
        this.midtermScore = midtermScore;
        this.termScore = termScore;
    }
}
