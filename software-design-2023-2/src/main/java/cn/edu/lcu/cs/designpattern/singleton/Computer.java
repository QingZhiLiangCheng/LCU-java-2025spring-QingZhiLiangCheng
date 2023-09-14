package cn.edu.lcu.cs.designpattern.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Computer {
    private String brand;
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

    private static Computer instance;

    private Computer() {
    }

    public static Computer getInstance() {
        if (instance==null) {
            instance = new Computer();
        }
        return instance;
    }

}
