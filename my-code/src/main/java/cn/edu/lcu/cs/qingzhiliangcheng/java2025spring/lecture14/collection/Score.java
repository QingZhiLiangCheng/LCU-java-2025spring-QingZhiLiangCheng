package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.collection;


import cn.edu.lcu.cs.javaprogramming.annotations.Range;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

/**
 * 成绩类
 *
 * @author ling
 */
@Data
@Builder
public class Score implements Comparable<Score>, Serializable {
    /**
     * 唯一的ID，一般对应于数据库表中的主键。
     */
    private Long id;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 姓名
     */
    private String studentName;

    /**
     * 班级名称
     */
    private String clazzName;

    /**
     * 平时成绩
     */
//    @Range(min = 0, max = 100)
    @Range
    private Integer ordinaryScore;

    /**
     * 实验成绩
     */
    private Integer experimentScore;

    /**
     * 期中成绩
     */
    private Integer midtermScore;

    /**
     * 期末成绩
     */
    private Integer termScore;

    /**
     * 将本方法的返回值放入toString
     *
     * @return 总成绩构成：平时成绩10% 期中成绩20% 期末成绩40% 实验成绩30%。
     */
    @ToString.Include(name = "totalScore")
    public Double getTotalScore() {
        int ordinaryScore = this.ordinaryScore != null ? this.ordinaryScore : 0;
        int midtermScore = this.midtermScore != null ? this.midtermScore : 0;
        int termScore = this.termScore != null ? this.termScore : 0;
        int experimentScore = this.experimentScore != null ? this.experimentScore : 0;

        return ordinaryScore * 0.1 + midtermScore * 0.2 + termScore * 0.4 + experimentScore * 0.3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(id, score.id) && Objects.equals(studentNo, score.studentNo) && Objects.equals(studentName, score.studentName) && Objects.equals(clazzName, score.clazzName) && Objects.equals(ordinaryScore, score.ordinaryScore) && Objects.equals(experimentScore, score.experimentScore) && Objects.equals(midtermScore, score.midtermScore) && Objects.equals(termScore, score.termScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNo, studentName, clazzName, ordinaryScore, experimentScore, midtermScore, termScore);
    }

    @Override
    public int compareTo(Score otherScore) {
        return this.getTotalScore().compareTo(otherScore.getTotalScore());
    }

}
