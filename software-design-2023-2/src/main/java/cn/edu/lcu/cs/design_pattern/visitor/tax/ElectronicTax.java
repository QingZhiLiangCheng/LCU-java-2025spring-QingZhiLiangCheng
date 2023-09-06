package cn.edu.lcu.cs.design_pattern.visitor.tax;

public class ElectronicTax implements BusinessTax {
    @Override
    public String getData() {
        return "ElectronicTax.getData";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
