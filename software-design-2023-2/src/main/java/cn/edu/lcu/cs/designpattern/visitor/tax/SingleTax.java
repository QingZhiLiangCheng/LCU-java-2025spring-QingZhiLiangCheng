package cn.edu.lcu.cs.designpattern.visitor.tax;

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
