package cn.edu.lcu.cs.design_pattern.composite.organization;

public class ItDepartment extends OrganizationComponent {

    public ItDepartment(String name) {
        super(name);
    }

    @Override
    public int getStaffCount() {
        return 20;
    }

    @Override
    public void add(OrganizationComponent organization) {
        throw new UnsupportedOperationException(this.getName()+"已经是最基本部门，无法增加下属部门");
    }

    @Override
    public OrganizationComponent getChild(String orgName) {
        if(getName().equals(orgName)){
            return this;
        }
        return null;
    }
}

