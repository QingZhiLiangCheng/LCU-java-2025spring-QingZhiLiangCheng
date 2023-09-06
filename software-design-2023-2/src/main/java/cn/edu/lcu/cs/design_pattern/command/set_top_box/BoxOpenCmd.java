package cn.edu.lcu.cs.design_pattern.command.set_top_box;


/**
 * 机顶盒开机命令
 */
public class BoxOpenCmd extends BoxCmd {
    public BoxOpenCmd() {
        super();
    }

    @Override
    public void execute() {
        getBox().open();
    }
}
