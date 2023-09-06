package cn.edu.lcu.cs.design_pattern.visitor.score;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成绩基类
 */
@Data
@NoArgsConstructor
public abstract class Score {
    private String studentNo;
    private String studentName;
    private String courseName;
    private Integer ordinaryScore; // 平时成绩
//    private Integer experimentScore; // 实验成绩
    private Integer midtermScore; // 期中成绩
    private Integer termScore; // 期末成绩
    /**
     * 某门课程最终成绩，可能由平时成绩、实验成绩、期中成绩、期末成绩等构成。
     * @return
     */
    private Double score;

    public abstract void accept(Visitor visitor) ;

    public Score(String studentNo, String studentName, String courseName, Integer ordinaryScore, Integer midtermScore, Integer termScore) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.courseName = courseName;
        this.ordinaryScore = ordinaryScore;
        this.midtermScore = midtermScore;
        this.termScore = termScore;
    }
}
