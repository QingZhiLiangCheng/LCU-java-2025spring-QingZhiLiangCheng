package cn.edu.lcu.cs.designpattern.bridge.shape;

public class Circle extends Shape {
    public Circle(ColorPen color) {
        super(color);
        setDescription("圆形");
    }

    @Override
    public void draw() {
        // 设置笔的颜色（控制台文字颜色）
        getPen().setColor();
        System.out.println(getDescription());
    }
}
