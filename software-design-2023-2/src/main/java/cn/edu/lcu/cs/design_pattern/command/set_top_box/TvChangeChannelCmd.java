package cn.edu.lcu.cs.design_pattern.command.set_top_box;

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
