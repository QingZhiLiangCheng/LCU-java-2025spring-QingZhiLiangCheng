package cn.edu.lcu.cs.basic.program_principle.dip.computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ling
 * @date 2022/8/29 20:17
 */
@Getter
@Setter
@AllArgsConstructor
public class SeagateHardDisk implements HardDisk {
    private String diskName;
    /**
     * 容量
     */
    private Integer capacity;

    @Override
    public void save() {

    }

    @Override
    public void read() {

    }
}
