package cn.edu.lcu.cs.basic.program_principle.dip.computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ling
 * @date 2022/8/29 20:25
 */
@Getter
@Setter
@AllArgsConstructor
public class SamsungMem implements Mem {
    /**
     * 品牌
     */
    private String brand;
    /**
     * 容量
     */
    private Integer capacity;

    @Override
    public void randomAccess() {

    }
}
