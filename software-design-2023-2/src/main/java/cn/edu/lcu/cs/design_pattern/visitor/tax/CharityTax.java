package cn.edu.lcu.cs.design_pattern.visitor.tax;

public class CharityTax implements Tax {
    @Override
    public String getData() {
        return "CharityTax.getData";
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
