package cn.edu.lcu.cs.design_pattern.builder.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lombok builder 演示
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}
