package cn.edu.lcu.cs.designpattern.visitor.pet;

public interface Pet {
    void accept(Feeder feeder);
}