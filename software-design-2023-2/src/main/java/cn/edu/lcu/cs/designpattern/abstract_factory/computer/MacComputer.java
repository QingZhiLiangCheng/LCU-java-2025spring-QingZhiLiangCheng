package cn.edu.lcu.cs.designpattern.abstract_factory.computer;

public class MacComputer extends Computer {
    @Override
    public void setOperationSystem() {
        System.out.println("Mac笔记本安装Mac系统");
    }
}