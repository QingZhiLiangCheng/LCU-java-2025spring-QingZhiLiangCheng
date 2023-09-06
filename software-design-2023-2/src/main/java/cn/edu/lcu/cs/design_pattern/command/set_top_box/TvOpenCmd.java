package cn.edu.lcu.cs.design_pattern.command.set_top_box;

import lombok.Data;

@Data
public class TvOpenCmd extends TelevisionCmd {
    public TvOpenCmd() {
        super();
    }

    @Override
    public void execute() {
        getTv().open();
    }
}
