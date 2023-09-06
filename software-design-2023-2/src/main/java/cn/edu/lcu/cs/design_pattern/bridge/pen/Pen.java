package cn.edu.lcu.cs.design_pattern.bridge.pen;

public abstract class Pen {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(String name);
}
