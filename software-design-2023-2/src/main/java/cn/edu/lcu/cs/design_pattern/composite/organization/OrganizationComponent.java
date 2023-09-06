package cn.edu.lcu.cs.design_pattern.composite.organization;

public abstract class OrganizationComponent {
    private String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void add(OrganizationComponent organization);

    public abstract OrganizationComponent getChild(String orgName);

    public abstract int getStaffCount();

    @Override
    public String toString() {
        return name;
    }
}
