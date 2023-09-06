package cn.edu.lcu.cs.design_pattern.visitor.staff;

import java.util.LinkedList;
import java.util.List;

// 员工业务报表类
public class Client {

    private List<Staff> staffs = new LinkedList<>();

    public Client() {
        staffs.add(new Manager("经理-A"));
        staffs.add(new Engineer("工程师-A"));
        staffs.add(new Engineer("工程师-B"));
        staffs.add(new Engineer("工程师-C"));
        staffs.add(new Manager("经理-B"));
        staffs.add(new Engineer("工程师-D"));
    }

    /**
     * 为访问者展示报表
     *
     * @param visitor 公司高层，如CEO、CTO
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : staffs) {
//            staff.accept(visitor);
            visitor.visit(staff);
        }
    }

    public static void main(String[] args) {
        // 构建报表
        Client client = new Client();

        System.out.println("=========== CEO看报表 ===========");
        client.showReport(new CEOVisitor());

        System.out.println("=========== CTO看报表 ===========");
        client.showReport(new CTOVisitor());
    }
}