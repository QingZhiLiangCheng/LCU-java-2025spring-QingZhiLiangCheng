package cn.edu.lcu.cs.designpattern.visitor.tax;

public interface Tax {
    String getData();

    void accept(Visitor visitor);
}
