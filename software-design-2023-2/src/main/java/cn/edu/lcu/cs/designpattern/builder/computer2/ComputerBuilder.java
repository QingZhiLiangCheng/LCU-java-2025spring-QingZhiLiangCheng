package cn.edu.lcu.cs.designpattern.builder.computer2;

import java.util.Map;

/**
 * 电脑Builder接口，有一些实现类，如戴尔电脑组装者、联想电脑组装者，等等
 */
public interface ComputerBuilder {
    ComputerBuilder buildBoard(String board);
    ComputerBuilder buildCpu(String cpu);
    ComputerBuilder buildMemory(String memory);
    ComputerBuilder buildDisk(String disk);
    ComputerBuilder buildVideoCard(String videoCard);
    ComputerBuilder buildDisplay(String display);
    ComputerBuilder buildKey(String Key);
    ComputerBuilder buildMouse(String mouse);
    ComputerBuilder buildAudio(String audio);
    ComputerBuilder buildOs(String os);

    /**
     * @return 组装好的电脑
     */
    Computer getComputer();

    /**
     * @param config 电脑配置单
     */
    Computer build(Map<String, String> config);
}
