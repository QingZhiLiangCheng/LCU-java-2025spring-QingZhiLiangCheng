package cn.edu.lcu.cs.design_pattern.state.cdplayer;

/**
 * 开机状态，只能执行播放、关机、更换CD命令
 */
public class PowerOnState extends PlayerState {
    public PowerOnState(CDPlayer player) {
        super(player);
    }

    /**
     * 播放命令
     * 若播放器里有cd就进入播放状态；如果没有cd，保持开机状态。
     */
    @Override
    public void play() {
        CD cd = player.getCd();
        if (cd == null) {
            printTransitionInfo("on", "on");
            System.out.printf("\tno cd\n");
        } else {
            // 设置新状态
            player.setState(new PlayingState(player));
            // 打印状态转换信息
            printTransitionInfo("on", "playing");
            System.out.printf("\tplaying cd %s\n", cd.getName());
        }
    }

    /**
     * 关机命令
     */
    @Override
    public void off() {
        player.setState(new PowerOffState(player));
        printTransitionInfo("on", "off");
        System.out.println();
    }

    /**
     * 更换cd命令。
     *
     * @param cd
     */
    @Override
    public void replace(CD cd) {
        CD oldCd = player.getCd();
        player.setCd(cd);
        // 更换cd不会导致状态转换，所以没有设置新状态，仅打印了一行文本。
        printTransitionInfo("on", "on");
        System.out.printf("\t%s --> %s\n", oldCd == null ? "no cd" : oldCd.getName(), cd == null ? "no cd" : cd.getName());
    }
}
