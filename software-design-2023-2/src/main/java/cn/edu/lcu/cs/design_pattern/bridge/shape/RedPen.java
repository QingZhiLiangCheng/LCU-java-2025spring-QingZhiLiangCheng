package cn.edu.lcu.cs.design_pattern.bridge.shape;

import cn.edu.lcu.cs.util.ConsoleColor;

public class RedPen implements ColorPen {
    @Override
    public void setColor() {
        // 设置控制台前景色为红色
        System.out.print(ConsoleColor.FG_RED);
    }
}
