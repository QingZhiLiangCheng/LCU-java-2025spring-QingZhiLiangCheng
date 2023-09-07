package cn.edu.lcu.cs.designpattern.command.set_top_box;

import lombok.Data;

@Data
public class BoxCloseCmd extends BoxCmd {
    public BoxCloseCmd() {
        super();
    }

    @Override
    public void execute() {
        getBox().close();
    }
}
