package cn.edu.lcu.cs.design_pattern.builder.computer;

/**
 * 电脑组装的指挥者，负责装配零部件的顺序。
 * 有时指挥者也可缺失，装配流程直接由客户类决定。
 */
public class Director {
    private ComputerBuilder builder;

    public Director() {
    }

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    /**
     * 组装电脑，由指挥者决定装配的顺序。
     * 若指挥者类缺失，也可由客户类直接指定装配流程。
     */
    public void construct() {
        // 普通调用
        builder.buildBoard();
        builder.buildCpu();
        // builder.build()方法返回自身的引用，可以级联调用
        builder.buildMemory()
                .buildDisk()
                .buildVideoCard()
                .buildDisplay()
                .buildKey()
                .buildMouse()
                .buildAudio()
                .buildOs();
    }

    /**
     * 获取装配好的电脑
     *
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
