package cn.edu.lcu.cs.design_pattern.visitor.score;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        // 此成绩列表可以看作简单的ObjectStructure对象，没有再单独成类。
        List<Score> scores = new ScoreDB().findAll();

        JavaTeacher javaTeacher = new JavaTeacher("王老师");
        DesignPatternTeacher designPatternTeacher = new DesignPatternTeacher("李老师");
        Student student = new Student("李四", "002");

        // 两位老师访问成绩列表，计算相应课程的最终成绩
        scores.forEach(score -> score.accept(javaTeacher));
        scores.forEach(score -> score.accept(designPatternTeacher));

        // 学生访问成绩列表，提取自己的成绩
        scores.forEach(score -> score.accept(student));
        System.out.println(student);
        student.getScores().forEach(score -> System.out.println(score.getCourseName() + "\t" + score.getScore()));
        System.out.println(student.isAllPassed() ? "都及格了" : "有不及格的");
    }
}
