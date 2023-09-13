package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory.factory;

/**
 * @Description 计算机工厂客户类
 * @Author Ling
 * @Date 2021/9/3 20:08
 * @Version 1.0
 */
public class ComputerFacotryClient {
    public static void main(String[] args) {
        // 创建工厂类实例
        ComputerFactory factory = new XPSFactory();

        // 利用工厂类的方法创建指定型号的电脑，至于如何生产的，客户不需要操心
        Computer xps = factory.build();
        System.out.println("xps = " + xps);

        factory = new VostroFactory();
        Computer vostro = factory.build();
        System.out.println("vostro = " + vostro);



    }
}
