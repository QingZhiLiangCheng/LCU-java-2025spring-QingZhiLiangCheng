package cn.edu.lcu.cs.designpattern.factory.computer;

/**
 * @Description 计算机工厂客户类
 * @Author Ling
 * @Date 2021/9/3 20:08
 * @Version 1.0
 */
public class ComputerFacotryClient {
    public static void main(String[] args) {
        // 创建特定产品的工厂
        ComputerFactory xpsFactory = new XpsFactory();
        // 利用工厂类的方法创建指定型号的电脑，至于如何生产的，客户不需要操心
        Computer xps = xpsFactory.build();
        System.out.println(xps);

        ComputerFactory vostroFactory = new VostroFactory();
        Computer vostro = vostroFactory.build();
        System.out.println(vostro);

        ComputerFactory optiPlex3080Factory = new OptiPlex3080Factory();
        Computer optiPlex3080 = optiPlex3080Factory.build();
        System.out.println(optiPlex3080);
    }
}
