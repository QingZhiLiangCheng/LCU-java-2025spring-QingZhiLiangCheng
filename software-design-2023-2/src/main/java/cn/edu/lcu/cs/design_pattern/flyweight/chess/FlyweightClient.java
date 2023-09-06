package cn.edu.lcu.cs.design_pattern.flyweight.chess;

/**
 * 每种颜色的棋子只能有一个实例。
 */
public class FlyweightClient {

    public static void main(String[] args) {
        //下黑子
        Chess blackChess1 = ChessFactory.getChess(Color.BLACK);
        blackChess1.draw(2, 5);

        //下白子
        Chess whiteChess = ChessFactory.getChess(Color.WHITE);
        whiteChess.draw(3, 5);

        //下黑子
        Chess blackChess2 = ChessFactory.getChess(Color.BLACK);
        blackChess2.draw(2, 6);

        System.out.println(String.format("blackChess1:%d | blackChess2:%d | whiteChess:%d",
                blackChess1.hashCode(), blackChess2.hashCode(), whiteChess.hashCode()));
    }
}
