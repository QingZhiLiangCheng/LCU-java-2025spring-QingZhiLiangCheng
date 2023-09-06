package cn.edu.lcu.cs.design_pattern.visitor.tax;

public interface Visitor {
    void visit(SingleTax tax);

    void visit(CharityTax tax);

    void visit(ElectronicTax tax);

    void visit(EntertainmentTax tax);

    void visit(FamilyTax tax);
}
