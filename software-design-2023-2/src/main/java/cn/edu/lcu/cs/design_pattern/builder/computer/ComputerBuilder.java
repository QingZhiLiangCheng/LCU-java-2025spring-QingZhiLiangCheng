package cn.edu.lcu.cs.design_pattern.builder.computer;

/**
 * 电脑Builder接口，定义了零部件生产组装的一系列方法，不负责整机的组装。
 * 整机的组装流程由指挥者Director负责。
 */
public interface ComputerBuilder {
    /**
     * 生产装配主板。
     * 返回类型为什么不是Computer？
     * 为什么不是void？
     * 为什么是ComputerBuilder？
     *
     * @return
     */
    ComputerBuilder buildBoard();

    ComputerBuilder buildCpu();

    ComputerBuilder buildMemory();

    ComputerBuilder buildDisk();

    ComputerBuilder buildVideoCard();

    ComputerBuilder buildDisplay();

    ComputerBuilder buildKey();

    ComputerBuilder buildMouse();

    ComputerBuilder buildAudio();

    ComputerBuilder buildOs();

    /**
     * @return 组装好的电脑
     */
    Computer getComputer();
}
