package cn.edu.lcu.cs.design_pattern.builder.computer;

/**
 * 具体的建造者，负责Dell电脑零部件的生产。
 * TODO 部件的属性都是硬编码，仅供演示用。
 * 应该将构建过程与具体属性解耦，比如从网络或配置文件中读取属性。
 */
public class DellBuilder implements ComputerBuilder {
    /**
     * 装配过程中的电脑
     */
    private Computer computer;

    public DellBuilder() {
        this.computer = new Computer();
    }

    /**
     * 生产装配电脑主板
     *
     * @return
     */
    @Override
    public ComputerBuilder buildBoard() {
        // 生产装配各种组件，可能会很复杂
        computer.setBoard("Dell主板");
        return this;
    }

    @Override
    public ComputerBuilder buildCpu() {
        computer.setCpu("第十代智能英特尔® 酷睿™ i7-10700F 处理器");
        return this;
    }

    @Override
    public ComputerBuilder buildMemory() {
        computer.setMemory("8GB, 8Gx1, DDR4, 2933MHz");
        return this;
    }

    @Override
    public ComputerBuilder buildDisk() {
        computer.setDisk("512GB M.2 PCIe NVMe 固态硬盘");
        return this;
    }

    @Override
    public ComputerBuilder buildVideoCard() {
        computer.setVideoCard("NVIDIA® GeForce® GT™ 730 2GB GDDR5");
        return this;
    }

    @Override
    public ComputerBuilder buildDisplay() {
        computer.setDisplay("27英寸微边框显示器 S2719H");
        return this;
    }

    @Override
    public ComputerBuilder buildKey() {
        computer.setKey("Dell无线键鼠套装");
        return this;
    }

    @Override
    public ComputerBuilder buildMouse() {
        computer.setMouse("Dell无线键鼠套装");
        return this;
    }

    @Override
    public ComputerBuilder buildAudio() {
        computer.setAudio("Dell品牌6.1音箱");
        return this;
    }

    /**
     * 装配OS参数
     *
     * @return 自身引用，方便级联调用
     */
    @Override
    public ComputerBuilder buildOs() {
        computer.setOs("Windows 10 家庭单语言版");
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
