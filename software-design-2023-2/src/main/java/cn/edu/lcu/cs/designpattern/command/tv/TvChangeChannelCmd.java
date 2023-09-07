package cn.edu.lcu.cs.designpattern.command.tv;

public class TvChangeChannelCmd extends Command {
    private String channel;

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public TvChangeChannelCmd(Television tv) {
        super(tv);
    }

    public TvChangeChannelCmd() {
        tv = new Television();
    }

    @Override
    public void execute() {
        tv.changeChannel(channel);
    }
}
