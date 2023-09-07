package cn.edu.lcu.cs.designpattern.state.trafficlight.first;

/**
 * 交通灯（状态）抽象基类，状态改变由环境类负责
 * 若要扩充新状态，从基类派生新子类，基类基本不用变动
 * 环境类的change()方法需要修改，添加新的条件分支
 */
public abstract class TrafficLight {
    private Color color;

    protected TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public enum Color {
        RED, GREEN, YELLOW
    }
}
