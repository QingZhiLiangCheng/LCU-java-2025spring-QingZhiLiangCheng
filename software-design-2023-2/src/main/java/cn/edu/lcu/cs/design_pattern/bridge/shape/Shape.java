package cn.edu.lcu.cs.design_pattern.bridge.shape;

import lombok.Data;

@Data
public abstract class Shape {
    private ColorPen pen;
    private String description;

    public Shape(ColorPen pen) {
        this.pen = pen;
    }
    public abstract void draw();
}
