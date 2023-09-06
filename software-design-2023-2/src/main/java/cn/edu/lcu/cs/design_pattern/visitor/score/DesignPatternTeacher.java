package cn.edu.lcu.cs.design_pattern.visitor.score;

import lombok.Data;

/**
 * 设计模式课程教师访问者，只关注本课程的成绩，成绩计算方法与其它课程不同。
 */
@Data
public class DesignPatternTeacher extends Visitor {
    private String courseName;

    public DesignPatternTeacher(String name) {
        super(name);
        this.courseName = ScoreDB.COURSE_NAME_DESIGN_PATTERN;
    }

    @Override
    public void visit(JavaScore score) {
    }

    /**
     * 计算最终成绩
     *
     * @param score 计算出的最终成绩
     */
    @Override
    public void visit(DesignPatternScore score) {
        // 平时成绩0.1  期中成绩0.2 期末成绩0.4 实验成绩0.3
        score.setScore(score.getOrdinaryScore() * 0.1 + score.getMidtermScore() * 0.2 + score.getTermScore() * 0.4 + score.getExperimentScore() * 0.3);
    }
}
