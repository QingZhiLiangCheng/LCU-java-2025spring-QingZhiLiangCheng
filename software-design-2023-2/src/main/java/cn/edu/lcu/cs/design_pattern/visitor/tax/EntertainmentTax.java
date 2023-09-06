package cn.edu.lcu.cs.design_pattern.visitor.tax;

public class EntertainmentTax implements BusinessTax {
    @Override
    public String getData() {
        return "EntertainmentTax.getData";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
