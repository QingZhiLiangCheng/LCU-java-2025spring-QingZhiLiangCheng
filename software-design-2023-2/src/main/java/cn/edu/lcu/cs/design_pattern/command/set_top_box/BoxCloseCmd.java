package cn.edu.lcu.cs.design_pattern.command.set_top_box;

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
