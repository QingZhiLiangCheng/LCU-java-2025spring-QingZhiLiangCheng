package cn.edu.lcu.cs.design_pattern.visitor.demo;

//抽象元素类
public interface Element {
    void accept(Visitor visitor);
}
