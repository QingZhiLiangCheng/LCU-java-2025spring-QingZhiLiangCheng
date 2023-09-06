package cn.edu.lcu.cs.design_pattern.command.set_top_box;

import lombok.Data;

@Data
public class TvCloseCmd extends TelevisionCmd {

    public TvCloseCmd() {
        super();
    }

    @Override
    public void execute() {
        getTv().close();
    }
}
