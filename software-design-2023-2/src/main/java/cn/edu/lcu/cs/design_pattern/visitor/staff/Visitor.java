package cn.edu.lcu.cs.design_pattern.visitor.staff;

public interface Visitor {
    default void visit(Staff staff){
        if (staff instanceof Engineer) {
        }
    }

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}