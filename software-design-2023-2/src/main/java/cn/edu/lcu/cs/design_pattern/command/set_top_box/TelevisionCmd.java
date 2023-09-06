package cn.edu.lcu.cs.design_pattern.command.set_top_box;

import lombok.Data;

@Data
public abstract class TelevisionCmd extends Command {
    private Television tv;
    private String channel;

    public TelevisionCmd() {
        tv = new Television();
    }
}
