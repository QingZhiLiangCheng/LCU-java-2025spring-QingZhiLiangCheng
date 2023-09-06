package cn.edu.lcu.cs.design_pattern.visitor.tax;

public class SingleTax implements IndividuleTax {
    @Override
    public String getData() {
        return "SingleTax.getData";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
