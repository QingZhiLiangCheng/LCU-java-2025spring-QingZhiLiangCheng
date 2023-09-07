package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory;

/**
 * @Description 计算机工厂类
 * @Author Ling
 * @Date 2021/9/3 20:00
 * @Version 1.0
 */
public class ComputerFactory {
    /**
     * 工厂方法，根据指定的参数生产各种电脑
     *
     * @param model 型号名称
     * @return
     */
    public Computer build(String model) {
        Computer computer = null;
        switch (model) {
            case "OptiPlex3080":
                computer = new OptiPlex3080();
                break;
            case "XPS":
                computer = new XPS();
                break;
            case "Vostro":
                computer = new Vostro();
                break;
            default:
                break;
        }
        return computer;
    }
}
