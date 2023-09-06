package cn.edu.lcu.cs.design_pattern.abstract_factory.computer;

/**
 *
 * @author ling
 * @date 2022/8/30 11:03
 */
public class AbstractFactoryClient {
    public static void main(String[] args) {
        //使用苹果工厂生产苹果公司的系列产品
        AbstractFactory appleFactory = new AppleFactory();
        appleFactory.makeComputer().setOperationSystem();
        appleFactory.makeMobilePhoto().setOperationSystem();

        //使用小米工厂生产小米公司的系列产品
        AbstractFactory miFactory = new XiaoMiFactory();
        miFactory.makeComputer().setOperationSystem();
        miFactory.makeMobilePhoto().setOperationSystem();
    }

}
