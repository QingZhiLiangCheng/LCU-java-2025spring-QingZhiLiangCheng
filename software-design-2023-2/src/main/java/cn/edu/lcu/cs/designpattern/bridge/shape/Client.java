package cn.edu.lcu.cs.designpattern.bridge.shape;

public class Client {
    public static void main(String[] args) {
        RedPen redPen = new RedPen();
        Shape redCircle = new Circle(redPen);
        redCircle.draw();

        GreenPen greenPen = new GreenPen();
        Shape greenRectangle = new Rectangle(greenPen);
        greenRectangle.draw();

        Shape redRectangle = new Rectangle(redPen);
        redRectangle.draw();
    }
}
