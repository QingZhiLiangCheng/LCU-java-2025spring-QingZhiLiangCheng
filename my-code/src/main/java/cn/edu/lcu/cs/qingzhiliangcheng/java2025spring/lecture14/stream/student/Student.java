package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.stream.student;

import lombok.Data;

/**
 * 学生信息实体类
 * 用于存储学生的基本信息和成绩数据
 */
@Data
public class Student {
    /**
     * 学生唯一标识ID
     */
    private Integer id;

    /**
     * 所属班级名称
     */
    private String className;

    /**
     * 学号
     */
    private String studentId;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 日常成绩
     */
    private Double dailyScore;

    /**
     * 期中考试成绩
     */
    private Double midExam;

    /**
     * 期末考试成绩
     */
    private Double finalExam;

    /**
     * 总评成绩（日常*30% + 期中*30% + 期末*40%）
     */
    private Double totalScore;

    /**
     * 学生性别（"男"/"女"）
     */
    private String gender;

}
