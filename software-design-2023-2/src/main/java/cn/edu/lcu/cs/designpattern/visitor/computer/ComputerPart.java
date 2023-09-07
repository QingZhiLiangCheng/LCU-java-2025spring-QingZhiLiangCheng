package cn.edu.lcu.cs.designpattern.visitor.computer;

public interface ComputerPart {
    void accept(Visitor visitor);
    Double getPrice();
    String getDescription();
}
