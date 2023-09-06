package cn.edu.lcu.cs.design_pattern.visitor.staff;

import java.util.List;

public class ReportUtil {
    public void visit(Staff staff) {
        if (staff instanceof Manager) {
            Manager manager = (Manager) staff;
            System.out.println("经理: " + manager.name + ", KPI: " + manager.kpi +
                    ", 新产品数量: " + manager.getProducts());
        } else if (staff instanceof Engineer) {
            Engineer engineer = (Engineer) staff;
            System.out.println("工程师: " + engineer.name + ", KPI: " + engineer.kpi);
        }
    }

    public void visit(Engineer engineer) {
        System.out.println("工程师: " + engineer.name + ", KPI: " + engineer.kpi);
    }

    public void visit(Manager manager) {
        System.out.println("经理: " + manager.name + ", KPI: " + manager.kpi + ", 新产品数量: " + manager.getProducts());
    }

    public static void main(String[] args) {
        List<Staff> staffs = new StaffBuilder().getStaffs();
        CEOVisitor ceoVisitor = new CEOVisitor();
        staffs.forEach(staff -> staff.accept(ceoVisitor));

        CTOVisitor ctoVisitor = new CTOVisitor();
        staffs.forEach(staff -> staff.accept(ctoVisitor));
    }
}