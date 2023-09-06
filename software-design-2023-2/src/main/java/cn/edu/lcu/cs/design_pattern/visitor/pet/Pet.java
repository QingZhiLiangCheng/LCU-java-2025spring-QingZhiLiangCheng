package cn.edu.lcu.cs.design_pattern.visitor.pet;

public interface Pet {
    void accept(Feeder feeder);
}