package cn.edu.lcu.cs.designpattern.visitor.tax;

public class FamilyTax implements IndividuleTax {
    @Override
    public String getData() {
        return "FamilyTax.getData";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
