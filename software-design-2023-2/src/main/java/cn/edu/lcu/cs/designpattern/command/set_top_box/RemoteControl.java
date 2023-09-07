package cn.edu.lcu.cs.designpattern.command.set_top_box;

/**
 * 遥控器，可遥控电视机或者机顶盒，但是它不与电视机或机顶盒直接交互。
 */
public class RemoteControl {

    public void openTv() {
        new TvOpenCmd().execute();
    }

    public void closeTv() {
        new TvCloseCmd().execute();
    }

    public void changeTvChannel(String channel) {
        new TvChangeChannelCmd(channel).execute();
    }

    public void openBox() {
        new BoxOpenCmd().execute();
    }

    public void closeBox() {
        new BoxCloseCmd().execute();
    }

    public void changeBoxChannel(String channel) {
        new BoxChangeChannelCmd(channel).execute();
    }

}
