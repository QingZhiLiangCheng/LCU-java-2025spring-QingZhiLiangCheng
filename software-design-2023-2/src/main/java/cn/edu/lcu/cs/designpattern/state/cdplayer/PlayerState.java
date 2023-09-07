package cn.edu.lcu.cs.designpattern.state.cdplayer;

/**
 * 播放器状态抽象类，定义了各状态下所有可能调用的方法。
 * 某些方法不能在某些状态下调用，所以本类中所有这些方法一律打印出错提示。
 * 各状态可以调用的方法在各个状态子类中重新定义。
 */
public abstract class PlayerState {
    protected CDPlayer player;

    public PlayerState(CDPlayer player) {
        this.player = player;
    }

    /**
     * 开机
     */
    public void on() {
        illegalCaller();
    }

    /**
     * 关机
     */
    public void off() {
        illegalCaller();
    }

    /**
     * 暂停
     */
    public void pause() {
        illegalCaller();
    }

    /**
     * 播放
     */
    public void play() {
        illegalCaller();
    }

    /**
     * 停止
     */
    public void stop() {
        illegalCaller();
    }

    /**
     * 更换CD
     *
     * @param cd
     */
    public void replace(CD cd) {
        illegalCaller();
    }

    /**
     * 处理非法操作问题，抛出异常或打印错误信息到控制台
     */
    private void illegalCaller() {
//        throw new IllegalCallerException("非法调用\t" + this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName());
        System.out.println("!!!!!!!!!\t非法调用\t" + this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    /**
     * 打印状态转换信息到控制台
     *
     * @param oldState 旧状态
     * @param newState 新状态
     */
    protected void printTransitionInfo(String oldState, String newState) {
        // 打印信息如示，状态名+方法名：PowerOffState.on	off	-->	on
        System.out.printf("%s\t%s\t-->\t%s", this.getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName(), oldState, newState);
    }
}
