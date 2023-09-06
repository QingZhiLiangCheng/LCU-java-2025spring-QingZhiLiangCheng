package cn.edu.lcu.cs.design_pattern.builder.computer.reduced;

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
    private String os;

    @Override
    public String toString() {
        return "Computer{" +
                "\n\tbrand='" + brand + '\'' +
                "\n\tboard='" + board + '\'' +
                "\n\tcpu='" + cpu + '\'' +
                "\n\tmemory='" + memory + '\'' +
                "\n\tdisk='" + disk + '\'' +
                "\n\tos='" + os + '\'' +
                "\n}";
    }
}
