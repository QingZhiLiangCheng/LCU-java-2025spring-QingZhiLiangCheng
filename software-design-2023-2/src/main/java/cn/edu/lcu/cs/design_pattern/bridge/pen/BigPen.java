package cn.edu.lcu.cs.design_pattern.bridge.pen;

//扩充抽象类
public class BigPen extends Pen {
    public void draw(String name) {
        String penType = "大号毛笔绘制";
        this.color.bepaint(penType, name);
    }
}
