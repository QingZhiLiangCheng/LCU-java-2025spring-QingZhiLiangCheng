package cn.edu.lcu.cs.designpattern.visitor.score;

import lombok.Data;

/**
 * Java课程教师访问者，只关注本课程的成绩，成绩计算方法与其它课程不同。
 */
@Data
public class JavaTeacher extends Visitor {
    private String courseName;

    public JavaTeacher(String name) {
        super(name);
        this.courseName = ScoreDB.COURSE_NAME_JAVA;
    }

    @Override
    public void visit(JavaScore score) {
        score.setScore(score.getOrdinaryScore() * 0.1 + score.getMidtermScore() * 0.4 + score.getTermScore() * 0.5);
    }

    @Override
    public void visit(DesignPatternScore score) {
    }
}
