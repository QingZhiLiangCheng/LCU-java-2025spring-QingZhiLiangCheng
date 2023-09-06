package cn.edu.lcu.cs.design_pattern.state.cdplayer;

/**
 * 播放状态，可以执行以下命令：停止，播放，关机，暂停
 */
public class PlayingState extends PlayerState {
    public PlayingState(CDPlayer player) {
        super(player);
    }

    /**
     * 停止，由播放状态切换到开机状态
     */
    @Override
    public void stop() {
        player.setState(new PowerOnState(player));
        printTransitionInfo("playing", "on");
        System.out.println();
    }

    /**
     * 播放，播放状态不变
     */
    @Override
    public void play() {
        // 播放状态下执行播放命令，状态不转换，仅打印信息
        printTransitionInfo("playing", "playing");
        System.out.printf("playing cd %s\n", player.getCd().getName());
    }

    /**
     * 关机，播放状态-->关机状态
     */
    @Override
    public void off() {
        player.setState(new PowerOffState(player));
        printTransitionInfo("playing", "off");
        System.out.println();
    }

    /**
     * 暂停，播放状态-->暂停状态
     */
    @Override
    public void pause() {
        player.setState(new PausingState(player));
        printTransitionInfo("playing", "pausing");
        System.out.println();
    }
}
