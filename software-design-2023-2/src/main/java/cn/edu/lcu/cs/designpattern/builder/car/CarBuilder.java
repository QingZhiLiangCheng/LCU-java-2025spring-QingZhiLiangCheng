package cn.edu.lcu.cs.designpattern.builder.car;

import java.util.List;

public interface CarBuilder {
    void setSequence(List<String> sequence);
    Car getCar();
}
