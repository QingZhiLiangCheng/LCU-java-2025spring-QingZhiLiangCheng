package cn.edu.lcu.cs.designpattern.command.undo;

import lombok.Data;

/**
 * 累加器，命令接收者。
 */
@Data
public class Accumulator {
    /**
     * 累加器的当前值
     */
    private int result;

    public Accumulator() {
        this.result = 0;
    }

    /**
     * 重置加法器
     */
    public void reset() {
        this.result = 0;
    }

    /**
     * 在原来基础上累加新数值
     *
     * @param num
     * @return
     */
    public int accumulate(int num) {
        return result += num;
    }
}
