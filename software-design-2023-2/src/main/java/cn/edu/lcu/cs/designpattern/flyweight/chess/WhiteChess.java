package cn.edu.lcu.cs.designpattern.flyweight.chess;

import lombok.Getter;

/**
 * @author ling
 * @date 2022/9/10 0:19
 */
@Getter
public class WhiteChess implements Chess {
    private static final Color color = Color.WHITE;
    private static final String shape = "圆形";

    @Override
    public void draw(int x, int y) {
        System.out.println(String.format("%s %s（%d, %d）", color, shape, x, y));
    }
}
