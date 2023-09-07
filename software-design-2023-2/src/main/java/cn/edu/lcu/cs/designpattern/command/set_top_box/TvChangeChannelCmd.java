package cn.edu.lcu.cs.designpattern.command.set_top_box;

import lombok.Data;

@Data
public class TvChangeChannelCmd extends TelevisionCmd {

    public TvChangeChannelCmd() {
        super();
    }

    public TvChangeChannelCmd(String channel) {
        super();
        setChannel(channel);
    }

    @Override
    public void execute() {
        getTv().changeChannel(getChannel());
    }
}
