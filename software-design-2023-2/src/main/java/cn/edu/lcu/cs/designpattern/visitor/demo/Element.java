package cn.edu.lcu.cs.designpattern.visitor.demo;

//抽象元素类
public interface Element {
    void accept(Visitor visitor);
}
