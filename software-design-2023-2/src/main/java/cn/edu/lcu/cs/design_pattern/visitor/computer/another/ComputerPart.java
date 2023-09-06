package cn.edu.lcu.cs.design_pattern.visitor.computer.another;

public interface ComputerPart {
    void accept(Visitor visitor);
    Double getPrice();
    String getDescription();
}
