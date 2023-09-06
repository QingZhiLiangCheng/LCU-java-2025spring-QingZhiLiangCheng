package cn.edu.lcu.cs.design_pattern.builder.computer.parameterized;

import java.util.Map;

/**
 * 具体的建造者，负责华为电脑零部件的生产。
 * 构建过程与具体属性解耦，从配置文件中读取属性。
 */
public class HuaweiBuilder implements ComputerBuilder {
    /**
     * 装配过程中的电脑
     */
    private Computer computer;
    /**
     * 电脑的配置单
     */
    private Map<String, String> config;

    public HuaweiBuilder() {
        this.computer = new Computer();
        computer.setBrand("华为电脑");
    }

    /**
     * 生产装配电脑主板，真实情况可能很复杂，此演示代码仅简单赋值而已。
     *
     * @return
     */
    @Override
    public ComputerBuilder buildBoard() {
        // Huawei的生产线，肯定只采用Huawei的主板，即使用户有特殊需求也不理会。
        String board = "华为主板";
        computer.setBoard(board);
        return this;
    }

    @Override
    public ComputerBuilder buildCpu() {
        // 从配置清单中查找CPU的配置
        String cpu = config.get("cpu");
        computer.setCpu(cpu);
        return this;
    }

    @Override
    public ComputerBuilder buildMemory() {
        computer.setMemory(config.get("memory"));
        return this;
    }

    @Override
    public ComputerBuilder buildDisk() {
        computer.setDisk(config.get("disk"));
        return this;
    }

    @Override
    public ComputerBuilder buildVideoCard() {
        computer.setVideoCard(config.get("videoCard"));
        return this;
    }

    @Override
    public ComputerBuilder buildMonitor() {
        String monitor = config.get("monitor");
        computer.setMonitor("华为显示器 " + monitor);
        return this;
    }

    @Override
    public ComputerBuilder buildKey() {
        computer.setKey("华为键盘");
        return this;
    }

    @Override
    public ComputerBuilder buildMouse() {
        computer.setMouse("华为鼠标");
        return this;
    }

    @Override
    public ComputerBuilder buildAudio() {
        computer.setAudio("华为6.1音箱");
        return this;
    }

    /**
     * 装配OS参数
     *
     * @return 自身引用，方便级联调用
     */
    @Override
    public ComputerBuilder buildOs() {
        computer.setOs(config.get("os"));
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void setConfig(Map config) {
        this.config = config;
    }
}
