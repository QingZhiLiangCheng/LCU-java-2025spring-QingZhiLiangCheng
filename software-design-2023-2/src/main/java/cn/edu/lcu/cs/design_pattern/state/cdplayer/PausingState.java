package cn.edu.lcu.cs.design_pattern.state.cdplayer;

/**
 * 暂停状态，可执行以下命令：关机，播放，停止
 */
public class PausingState extends PlayerState {
    public PausingState(CDPlayer player) {
        super(player);
    }

    @Override
    public void off() {
        player.setState(new PowerOffState(player));
        printTransitionInfo("pausing", "off");
        System.out.println();
    }

    @Override
    public void play() {
        player.setState(new PlayingState(player));
        printTransitionInfo("pausing", "playing");
        System.out.printf("\tplaying cd %s\n", player.getCd().getName());
    }

    @Override
    public void stop() {
        player.setState(new PowerOnState(player));
        printTransitionInfo("pausing", "on");
        System.out.println();
    }
}
