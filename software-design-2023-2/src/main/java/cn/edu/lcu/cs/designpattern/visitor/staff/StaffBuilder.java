package cn.edu.lcu.cs.designpattern.visitor.staff;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

// 员工业务报表类
@Data
public class StaffBuilder {

    private List<Staff> staffs = new LinkedList<>();

    public StaffBuilder() {
        staffs.add(new Manager("经理-A"));
        staffs.add(new Engineer("工程师-A"));
        staffs.add(new Engineer("工程师-B"));
        staffs.add(new Engineer("工程师-C"));
        staffs.add(new Manager("经理-B"));
        staffs.add(new Engineer("工程师-D"));
    }
}