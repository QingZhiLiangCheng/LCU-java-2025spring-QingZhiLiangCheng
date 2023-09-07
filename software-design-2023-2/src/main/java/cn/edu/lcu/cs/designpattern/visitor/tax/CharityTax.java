package cn.edu.lcu.cs.designpattern.visitor.tax;

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
