package cn.edu.lcu.cs.designpattern.state.lift;

/**
 * @description: 电梯状态
 * @author: ling
 * @since: 2021-11-01 14:50
 **/
public abstract class LiftState {
    /**
     * 当前楼层
     */
    private int currentFloor;

    /**
     * 目标楼层
     */
    private int targetFloor;

    /**
     * 电梯开门
     */
    public abstract void openDoor();

    /**
     * 电梯关门
     */
    public abstract void closeDoor();

    public abstract void run();

    public abstract void stop();
}
