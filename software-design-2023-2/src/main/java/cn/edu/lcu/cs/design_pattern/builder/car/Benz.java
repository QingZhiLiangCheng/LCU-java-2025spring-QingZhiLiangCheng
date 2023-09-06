package cn.edu.lcu.cs.design_pattern.builder.car;

public class Benz extends Car {
    @Override
    protected void start() {
        System.out.println("奔驰启动");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰停止");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰响喇叭");
    }
}
