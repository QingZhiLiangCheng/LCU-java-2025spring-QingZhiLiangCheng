package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory.factory;

/**
 * @Description 计算机工厂类
 * @Author Ling
 * @Date 2021/9/3 20:00
 * @Version 1.0
 */
public abstract class ComputerFactory {
    /**
     * 工厂方法，根据指定的参数生产各种电脑
     *
     * @return
     */
    public abstract Computer build();
}
