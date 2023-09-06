package cn.edu.lcu.cs.basic.program_principle.dip.computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ling
 * @date 2022/8/29 20:07
 */
@Setter
@Getter
@AllArgsConstructor
public class Computer {
    private HardDisk disk;
    private Cpu cpu;
    private Mem mem;

    void run() {
        disk.read();
        cpu.run();
        mem.randomAccess();
    }
}
