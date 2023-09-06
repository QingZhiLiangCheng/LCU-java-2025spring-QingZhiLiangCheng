package cn.edu.lcu.cs.design_pattern.builder.computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Computer{" +
                "\n\tbrand='" + brand + '\'' +
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
