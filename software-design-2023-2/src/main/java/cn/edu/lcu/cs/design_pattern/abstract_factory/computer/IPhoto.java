package cn.edu.lcu.cs.design_pattern.abstract_factory.computer;

public class IPhoto extends MobilePhoto {
    @Override
    public void setOperationSystem() {
        System.out.println("苹果手机安装IOS系统");
    }
}