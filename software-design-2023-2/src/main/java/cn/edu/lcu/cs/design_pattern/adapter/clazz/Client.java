package cn.edu.lcu.cs.design_pattern.adapter.clazz;

public class Client {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.operation1();
        target.operation2();
    }
}
