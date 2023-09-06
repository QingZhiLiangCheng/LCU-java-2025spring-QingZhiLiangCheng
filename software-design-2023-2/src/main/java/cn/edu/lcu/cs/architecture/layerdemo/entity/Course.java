package cn.edu.lcu.cs.architecture.layerdemo.entity;

public class Course {
    private Long id;
    private String name;
    private String courseNo; // 课程号
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public Course(Long id, String name, String courseNo) {
        this.id = id;
        this.name = name;
        this.courseNo = courseNo;
    }
}
