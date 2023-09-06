package cn.edu.lcu.cs.basic.program_principle.dip.computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ling
 * @date 2022/8/29 20:22
 */
@Getter
@Setter
@AllArgsConstructor
public class IntelCpu implements Cpu {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 主频
     */
    private Integer frequency;
    /**
     * cpu内核数量
     */
    private Integer coresNumber;

    @Override
    public void run() {

    }
}
