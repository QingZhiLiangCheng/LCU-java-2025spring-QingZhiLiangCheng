package cn.edu.lcu.cs.design_pattern.builder.computer_factory;

/**
 * @description: 电脑工厂接口
 * @author: ling
 * @since: 2021-09-07 16:34
 **/
public interface ComputerFactory {
    /**
     * 创建并组装电脑。
     * 电脑如何创建，如何组装，这个接口并没有强制规定，实现类可以随意发挥。
     *
     * @return 创建并组装好的电脑实例
     */
    Computer build();
}
