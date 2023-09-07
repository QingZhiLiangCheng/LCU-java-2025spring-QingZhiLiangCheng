package cn.edu.lcu.cs.designpattern.builder.computer.reduced;

/**
 * Builder Pattern示例：电脑组装，控制台演示程序
 */
public class Client {
    public static void main(String[] args) {
        // 创建Builder
        ComputerBuilder builder = new DellBuilder();
        // 创建指挥者，并与Builder绑定
        Director director = new Director(builder);
        // 指挥者指挥生产者生产电脑
        director.construct();
        // 获取构造好的电脑
        Computer computer = director.getComputer();
        System.out.println(computer);

        // 创建另外的生产者
        builder = new HuaweiBuilder();
        // 与指挥者绑定
        director.setBuilder(builder);
        // 指挥者指挥另外的生产者生产电脑，当然就生产别样的电脑
        director.construct();
        computer = director.getComputer();
        System.out.println(computer);

    }
}
