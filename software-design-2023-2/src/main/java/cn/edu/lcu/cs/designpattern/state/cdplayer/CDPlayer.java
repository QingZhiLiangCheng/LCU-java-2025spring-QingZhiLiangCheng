package cn.edu.lcu.cs.designpattern.state.cdplayer;

/**
 * CD播放机对象，持有状态对象。
 * 未采用状态模式之前，开机、关机、播放等各种方法需要根据当前状态及用户的选择，进行复杂的条件判断，以切入新的状态。
 * 采用状态模式之后，状态转换交给各个状态子类完成，避免了复杂的条件判断。
 *
 * @author Ling
 */
public class CDPlayer {
    private PlayerState state;
    private CD cd;

    public CDPlayer() {
        // 默认的初始状态是关机状态
        state = new PowerOffState(this);
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    /**
     * 开机命令
     */
    public void on() {
        state.on();
    }

    /**
     * 关机
     */
    public void off() {
        state.off();
    }

    /**
     * 暂停
     */
    public void pause() {
        state.pause();
    }

    /**
     * 播放
     */
    public void play() {
        state.play();
    }

    /**
     * 停止
     */
    public void stop() {
        state.stop();
    }

    /**
     * 更换CD
     *
     * @param cd
     */
    public void replace(CD cd) {
        state.replace(cd);
    }
}
