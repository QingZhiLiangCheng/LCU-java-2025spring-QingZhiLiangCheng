package cn.edu.lcu.cs.design_pattern.composite.organization;

public class CompositeClient {

    private static OrganizationComponent constructOrganization() {
        //构建总部
        OrganizationComposite head = new OrganizationComposite("总公司");
        AdminDepartment headAdmin = new AdminDepartment("总公司行政部");
        ItDepartment headIt = new ItDepartment("总公司It部");
        head.add(headAdmin);
        head.add(headIt);

        //构建分公司
        OrganizationComposite branch1 = new OrganizationComposite("天津分公司");
        AdminDepartment branch1Admin = new AdminDepartment("天津分公司行政部");
        ItDepartment branch1It = new ItDepartment("天津分公司It部");
        branch1.add(branch1Admin);
        branch1.add(branch1It);

        //将分公司加入到head中
        head.add(branch1);

        return head;
    }

    public static void main(String[] args) {
        OrganizationComponent org = constructOrganization();
        System.out.println(String.format("%s共有%d名员工",
                org.getName(), org.getStaffCount()));

        OrganizationComponent subOrg = org.getChild("天津分公司行政部");
        System.out.println(String.format("%s共有%d名员工",
                subOrg.getName(), subOrg.getStaffCount()));
    }
}
