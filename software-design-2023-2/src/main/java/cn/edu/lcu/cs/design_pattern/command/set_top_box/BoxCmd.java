package cn.edu.lcu.cs.design_pattern.command.set_top_box;

import lombok.Data;

/**
 * 机顶盒命令
 */
@Data
public abstract class BoxCmd extends Command {
    private SetTopBox box;
    private String channel;

    public BoxCmd() {
        box = new SetTopBox();
    }
}
