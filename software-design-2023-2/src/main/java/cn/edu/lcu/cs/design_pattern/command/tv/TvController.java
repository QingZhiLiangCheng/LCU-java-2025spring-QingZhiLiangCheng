package cn.edu.lcu.cs.design_pattern.command.tv;

/**
 * 电视遥控器，聚合命令对象，而不是
 */
public class TvController {
    private TvOpenCmd openCmd;
    private TvCloseCmd closeCmd;
    private TvChangeChannelCmd changeChannelCmd;

    public TvController() {
        openCmd = new TvOpenCmd();
        closeCmd = new TvCloseCmd();
        changeChannelCmd = new TvChangeChannelCmd();
    }

    public void open() {
        openCmd.execute();
    }

    public void close() {
        closeCmd.execute();
    }

    public void changeChannel(String channel) {
        changeChannelCmd.setChannel(channel);
        changeChannelCmd.execute();
    }
}
