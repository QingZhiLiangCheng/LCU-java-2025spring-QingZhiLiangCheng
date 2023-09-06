package cn.edu.lcu.cs.design_pattern.command.tv;

public class TvCloseCmd extends Command {
    public TvCloseCmd(Television tv) {
        super(tv);
    }

    public TvCloseCmd() {
    }

    @Override
    public void execute() {
        tv.close();
    }
}
