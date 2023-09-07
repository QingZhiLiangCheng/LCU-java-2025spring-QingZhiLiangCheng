package cn.edu.lcu.cs.designpattern.builder.computer_factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    private String brand; // 品牌
    private String model; // 型号
    private String board;
    private String cpu;
    private String memory;
    private String disk;
    private String videoCard;
    private String display;
    private String key;
    private String mouse;
    private String audio;
    private String os;

    public Computer(String cpu, String memory, String disk, String videoCard, String display, String os) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.videoCard = videoCard;
        this.display = display;
        this.os = os;
    }
}
