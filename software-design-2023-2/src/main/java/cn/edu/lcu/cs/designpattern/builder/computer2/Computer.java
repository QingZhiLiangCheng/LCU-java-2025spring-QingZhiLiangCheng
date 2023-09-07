package cn.edu.lcu.cs.designpattern.builder.computer2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
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

    @Override
    public String toString() {
        return "Computer{" +
                "\n\tboard='" + board + '\'' +
                "\n\tcpu='" + cpu + '\'' +
                "\n\tmemory='" + memory + '\'' +
                "\n\tdisk='" + disk + '\'' +
                "\n\tvideoCard='" + videoCard + '\'' +
                "\n\tdisplay='" + display + '\'' +
                "\n\tkey='" + key + '\'' +
                "\n\tmouse='" + mouse + '\'' +
                "\n\taudio='" + audio + '\'' +
                "\n\tos='" + os + '\'' +
                "\n}";
    }
}
