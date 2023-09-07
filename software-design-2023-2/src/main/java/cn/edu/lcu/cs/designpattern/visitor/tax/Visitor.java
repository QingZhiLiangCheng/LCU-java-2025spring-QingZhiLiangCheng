package cn.edu.lcu.cs.designpattern.visitor.tax;

public interface Visitor {
    void visit(SingleTax tax);

    void visit(CharityTax tax);

    void visit(ElectronicTax tax);

    void visit(EntertainmentTax tax);

    void visit(FamilyTax tax);
}
