package cn.edu.lcu.cs.design_pattern.simple_factory.computer_factory;

/**
 * @Description 静态工厂
 * @Author Ling
 * @Date 2021/9/3 20:00
 * @Version 1.0
 */
public class ComputerStaticFactory {
    /**
     * 静态工厂方法，根据指定的参数生产各种电脑
     *
     * @param model 型号名称
     * @return
     */
    public static Computer build(String model) {
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
