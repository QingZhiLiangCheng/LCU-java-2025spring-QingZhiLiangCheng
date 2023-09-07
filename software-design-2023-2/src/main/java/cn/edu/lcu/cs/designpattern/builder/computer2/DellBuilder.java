package cn.edu.lcu.cs.designpattern.builder.computer2;

import java.util.Map;

/**
 * 具体的建造者，负责Dell电脑零部件的生产。
 */
public class DellBuilder implements ComputerBuilder {
    private Computer computer;

    @Override
    public ComputerBuilder buildBoard(String board) {
        computer.setBoard(board);
        return this;
    }

    @Override
    public ComputerBuilder buildCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    @Override
    public ComputerBuilder buildMemory(String memory) {
        computer.setMemory(memory);
        return this;
    }

    @Override
    public ComputerBuilder buildDisk(String disk) {
        computer.setDisk(disk);
        return this;
    }

    @Override
    public ComputerBuilder buildVideoCard(String videoCard) {
        computer.setVideoCard(videoCard);
        return this;
    }

    @Override
    public ComputerBuilder buildDisplay(String display) {
        computer.setDisplay(display);
        return this;
    }

    @Override
    public ComputerBuilder buildKey(String Key) {
        computer.setKey(Key);
        return this;
    }

    @Override
    public ComputerBuilder buildMouse(String mouse) {
        computer.setMouse(mouse);
        return this;
    }

    @Override
    public ComputerBuilder buildAudio(String audio) {
        computer.setAudio(audio);
        return this;
    }

    /**
     * 装配OS参数
     *
     * @param os
     * @return 自身引用，方便级联调用
     */
    @Override
    public ComputerBuilder buildOs(String os) {
        computer.setOs(os);
        return this;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public Computer build(Map<String, String> config) {
        computer = new Computer();
        buildBoard("Dell主板");
        buildCpu(config.get("cpu"));
        buildMemory(config.get("memory"));
        buildDisk(config.get("disk"));
        buildVideoCard(config.get("videoCard"));
        buildDisplay(config.get("display"));
        buildKey("Dell无线键鼠套装");
        // build方法返回自身的引用，所以可以级联调用
        buildMouse("Dell无线键鼠套装").
                buildAudio("Dell品牌6.1音箱").
                buildOs(config.get("os"));
        return computer;
    }
}
