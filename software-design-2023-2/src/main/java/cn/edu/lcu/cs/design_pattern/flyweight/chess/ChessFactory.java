package cn.edu.lcu.cs.design_pattern.flyweight.chess;

import java.util.HashMap;
import java.util.Map;

/**
 * Chess工厂，创建实例。
 * 每种颜色只能有一个实例，所以不能不受限制的创建实例，需要专门的机制创建并管理这些实例。
 *
 * @author ling
 * @date 2022/9/10 0:27
 */
public class ChessFactory {
    /**
     * 保存已经创建的实例。
     * 每种颜色只能有一个实例。
     */
    private static final Map<Color, Chess> chessMap = new HashMap<Color, Chess>();

    /**
     * 根据颜色属性获取实例：如果尚未创建实例，就创建并加入映射。
     *
     * @param color 颜色（必须是外蕴属性，否则不能作为映射的Key）
     * @return
     */
    public static Chess getChess(Color color) {
        // 先试图从映射中获取实例
        Chess chess = chessMap.get(color);
        // 如果没有获取到，就创建新实例，并添加到映射中。
        if (chess == null) {
            chess = color == Color.WHITE ? new WhiteChess() : new BlackChess();
            chessMap.put(color, chess);
        }
        // 返回获取到的实例
        return chess;
    }
}
