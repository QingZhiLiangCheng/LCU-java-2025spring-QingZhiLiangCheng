package cn.edu.lcu.cs.design_pattern.command.tv;

public class TvOpenCmd extends Command {
    public TvOpenCmd(Television tv) {
        super(tv);
    }

    public TvOpenCmd() {
        tv = new Television();
    }

    @Override
    public void execute() {
        tv.open();
    }
}
