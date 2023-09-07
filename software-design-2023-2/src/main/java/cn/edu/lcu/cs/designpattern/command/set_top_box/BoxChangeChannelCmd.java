package cn.edu.lcu.cs.designpattern.command.set_top_box;

/**
 * 机顶盒换台命令
 */
public class BoxChangeChannelCmd extends BoxCmd {

    public BoxChangeChannelCmd() {
        super();
    }

    public BoxChangeChannelCmd(String channel) {
        super();
        setChannel(channel);
    }

    @Override
    public void execute() {
        getBox().changeChannel(getChannel());
    }
}
