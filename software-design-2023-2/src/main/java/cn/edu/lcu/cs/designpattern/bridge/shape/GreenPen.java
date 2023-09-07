package cn.edu.lcu.cs.designpattern.bridge.shape;

import cn.edu.lcu.cs.util.ConsoleColor;

public class GreenPen implements ColorPen {
    @Override
    public void setColor() {
        System.out.print(ConsoleColor.FG_GREEN); // 设置控制台前景色为绿色
    }
}
