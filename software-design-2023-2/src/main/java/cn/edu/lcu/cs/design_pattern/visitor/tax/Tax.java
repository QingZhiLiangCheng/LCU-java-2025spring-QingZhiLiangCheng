package cn.edu.lcu.cs.design_pattern.visitor.tax;

public interface Tax {
    String getData();

    void accept(Visitor visitor);
}
