package cn.edu.lcu.cs.designpattern.command.set_top_box;

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
