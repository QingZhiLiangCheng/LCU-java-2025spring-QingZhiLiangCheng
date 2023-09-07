package cn.edu.lcu.cs.designpattern.state.landing;

/**
 * 飞机着陆状态
 */
public abstract class AirLandingState {
    private String name; // 状态名
    private int speed; // 时速 公里/小时
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
