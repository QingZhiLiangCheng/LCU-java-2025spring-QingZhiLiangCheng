package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory;

/**
 * @Description 计算机静态工厂客户类
 * @Author Ling
 * @Date 2021/9/3 20:08
 * @Version 1.0
 */
public class ComputerStaticFacotryClient {
    public static void main(String[] args) {
        // 创建工厂本身就比较耗费资源
//        ComputerFactory factory = new ComputerFactory();

        // 可以使用静态工厂的静态方法，工厂本身不需要客户创建
        Computer xps = ComputerStaticFactory.build("XPS");
        System.out.println(xps);

        Computer vostro = ComputerStaticFactory.build("Vostro");
        System.out.println(vostro);

        Computer optiPlex3080 = ComputerStaticFactory.build("OptiPlex3080");
        System.out.println(optiPlex3080);
    }
}
