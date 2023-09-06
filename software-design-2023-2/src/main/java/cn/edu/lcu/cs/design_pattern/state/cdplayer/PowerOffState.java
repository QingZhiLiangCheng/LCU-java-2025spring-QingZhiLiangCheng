package cn.edu.lcu.cs.design_pattern.state.cdplayer;

/**
 * 关机状态
 */
public class PowerOffState extends PlayerState {
    public PowerOffState(CDPlayer player) {
        super(player);
    }

    /**
     * 关机状态只能调用开机命令
     */
    @Override
    public void on() {
        // 设置新状态
        player.setState(new PowerOnState(player));
        // 打印状态转换信息
        printTransitionInfo("off", "on");
        System.out.println();
    }
}
