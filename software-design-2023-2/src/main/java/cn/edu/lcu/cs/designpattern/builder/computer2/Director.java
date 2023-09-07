package cn.edu.lcu.cs.designpattern.builder.computer2;

import java.util.Map;

/**
 * 电脑组装的指挥者
 */
public class Director {
    private ComputerBuilder builder;

    public Director() {
    }

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    /**
     * 根据配置单组装电脑
     *
     * @param config 配置单列表
     */
    public void construct(Map<String, String> config) {
        builder.build(config);
    }

    /**
     * @return 组装好的电脑
     */
    public Computer getComputer() {
        return builder.getComputer();
    }

    public ComputerBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }
}
