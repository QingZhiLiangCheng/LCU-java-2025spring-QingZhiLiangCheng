package cn.edu.lcu.cs.designpattern.adapter.object;

public class Client {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.operation1();
        target.operation2();
        target.operation3();
    }
}
