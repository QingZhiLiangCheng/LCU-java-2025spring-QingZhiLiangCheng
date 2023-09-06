package cn.edu.lcu.cs.design_pattern.visitor.computer;

public interface ComputerPart {
    void accept(Visitor visitor);
    Double getPrice();
    String getDescription();
}
