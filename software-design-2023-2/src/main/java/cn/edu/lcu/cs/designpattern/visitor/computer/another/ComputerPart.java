package cn.edu.lcu.cs.designpattern.visitor.computer.another;

public interface ComputerPart {
    void accept(Visitor visitor);
    Double getPrice();
    String getDescription();
}
