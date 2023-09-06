package cn.edu.lcu.cs.design_pattern.abstract_factory.computer;

public class MiPhoto extends MobilePhoto {
    @Override
    public void setOperationSystem() {
        System.out.println("小米手机安装Android系统");
    }
}