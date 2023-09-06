package cn.edu.lcu.cs.design_pattern.factory.computer;

/**
 * @description: 电脑工厂接口
 * @author: ling
 * @since: 2021-09-07 16:34
 **/
public interface ComputerFactory {
    /**
     * 创建并组装电脑
     *
     * @return 创建并组装好的电脑实例
     */
    Computer build();
}
