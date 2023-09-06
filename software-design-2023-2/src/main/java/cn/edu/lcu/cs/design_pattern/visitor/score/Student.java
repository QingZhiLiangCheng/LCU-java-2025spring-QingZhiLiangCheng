package cn.edu.lcu.cs.design_pattern.visitor.score;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生访问者，只关注自己所有课程的成绩。
 */
@Data
@ToString(callSuper = true, exclude = "scores")
public class Student extends Visitor {
    private String studentNo;
    /**
     * 保存自己的各科成绩
     */
    private List<Score> scores = new ArrayList<>();

    public Student(String name, String studentNo) {
        super(name);
        this.studentNo = studentNo;
    }

    public Student() {

    }

    /**
     * @return 是否所有课程都及格了
     */
    public boolean isAllPassed() {
        // 用stream操作判断是否每个对象的成绩都及格了
        return scores.stream().allMatch(score -> score.getScore() >= 60);
        // 传统的操作，比stream操作繁琐。
//        for (Score score : scores) {
//            if (score.getScore() < 60) {
//                return false;
//            }
//        }
//        return true;
    }

    /**
     * 如果访问的成绩是自己的，就加入自己的成绩列表
     *
     * @param score
     */
    @Override
    public void visit(JavaScore score) {
        if (score != null && score.getStudentNo().equals(this.studentNo)) {
            scores.add(score);
        }
    }

    /**
     * 如果访问的成绩是自己的，就加入自己的成绩列表
     *
     * @param score
     */
    @Override
    public void visit(DesignPatternScore score) {
        if (score != null && score.getStudentNo().equals(this.studentNo)) {
            scores.add(score);
        }
    }
}
