package cn.edu.lcu.cs.design_pattern.builder.computer.parameterized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    private String brand;
    private String board;
    private String cpu;
    private String memory;
    private String disk;
    private String videoCard;
    private String monitor;
    private String key;
    private String mouse;
    private String audio;
    private String os;

    @Override
    public String toString() {
        return "Computer{" +
                "\n\tbrand='" + brand + '\'' +
                "\n\tboard='" + board + '\'' +
                "\n\tcpu='" + cpu + '\'' +
                "\n\tmemory='" + memory + '\'' +
                "\n\tdisk='" + disk + '\'' +
                "\n\tvideoCard='" + videoCard + '\'' +
                "\n\tmonitor='" + monitor + '\'' +
                "\n\tkey='" + key + '\'' +
                "\n\tmouse='" + mouse + '\'' +
                "\n\taudio='" + audio + '\'' +
                "\n\tos='" + os + '\'' +
                "\n}";
    }
}
