package cn.edu.lcu.cs.architecture.layerdemo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private String staffNo; // 教工号

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public Teacher() {
    }

    public Teacher(Long id, String username, String password, LocalDate birthdate, String staffNo) {
        super(id, username, password, birthdate);
        this.staffNo = staffNo;
    }
}
