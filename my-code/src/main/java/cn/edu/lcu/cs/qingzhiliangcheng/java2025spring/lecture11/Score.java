package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture11;


import lombok.Builder;
import lombok.Data;

/**
 * 成绩类
 */
@Data
@Builder
public class Score implements Comparable<Score> {
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
     * @return 总成绩构成：平时成绩10% 期中成绩20% 期末成绩40% 实验成绩30%。
     */
    public Double getTotalScore() {
        return ordinaryScore * 0.1 + midtermScore * 0.2 + termScore * 0.4 + experimentScore * 0.3;
    }

    @Override
    public int compareTo(Score ortherScore) {
        return this.getTotalScore().compareTo(ortherScore.getTotalScore());
    }

}