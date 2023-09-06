package cn.edu.lcu.cs.design_pattern.visitor.score;

import lombok.ToString;

/**
 * Java课程的成绩
 */
@ToString(callSuper = true) // Lombok生成的tostring()方法的输出中包含父类的属性
public class JavaScore extends Score{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public JavaScore(String studentNo, String studentName, String courseName, Integer ordinaryScore, Integer midtermScore, Integer termScore) {
        super(studentNo, studentName, courseName, ordinaryScore, midtermScore, termScore);
    }
}
