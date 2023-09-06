package cn.edu.lcu.cs.design_pattern.factory.computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Computer {
    private String brand; // 品牌
    private String model; // 型号
    private String cpu;
    private String memory;
    private String disk;
    private String display;

}
