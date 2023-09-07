package cn.edu.lcu.cs.designpattern.bridge.shape;

public class Rectangle extends Shape {
    public Rectangle(ColorPen pen) {
        super(pen);
        setDescription("矩形");
    }

    @Override
    public void draw() {
        getPen().setColor(); // 设置笔的颜色
        System.out.println(getDescription());
    }
}
