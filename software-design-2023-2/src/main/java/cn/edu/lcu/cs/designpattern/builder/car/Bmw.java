package cn.edu.lcu.cs.designpattern.builder.car;

public class Bmw extends Car {
    @Override
    protected void start() {
        System.out.println("宝马启动");
    }

    @Override
    protected void stop() {
        System.out.println("宝马停止");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马响喇叭");
    }
}
