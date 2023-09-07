package cn.edu.lcu.cs.designpattern.builder.computer;

/**
 * Builder Pattern示例：电脑组装，控制台演示程序
 */
public class Client {
    public static void main(String[] args) {
        // 创建Builder
        ComputerBuilder builder = new DellBuilder();
        // 创建指挥者，并与Builder绑定
        Director director = new Director(builder);
        // 生产装配电脑
        director.construct();
        Computer computer = director.getComputer();
        System.out.println(computer);
    }
}
