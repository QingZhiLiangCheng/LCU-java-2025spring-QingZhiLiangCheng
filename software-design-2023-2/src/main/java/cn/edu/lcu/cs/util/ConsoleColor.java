package cn.edu.lcu.cs.util;

/**
 * <p>控制台字体颜色</p>
 * <li>\u001b Escape键的ASCII码</li>
 * <li>转义序列格式：<strong>CSI n1 [;n2 [;…]] m</strong></li>
 * <li>CSI “控制序列引导器”（Control Sequence Introducer/Initiator），即<strong>\u001b[</strong></li>
 * <li>n1、n2: SGR参数，用；分隔</li>
 * <li>SGR参数列表如下</li>
 * <table>
 *     <tr>
 *         <th>编码</th>
 *         <th>说明</th>
 *     </tr>
 *     <tr>
 *         <td>0</td>
 *         <td>关闭所有格式，还原为初始状态</td>
 *     </tr>
 *     <tr>
 *         <td>1</td>
 *         <td>粗体/高亮显示</td>
 *     </tr>
 *     <tr>
 *         <td>2</td>
 *         <td>模糊（※）</td>
 *     </tr>
 *     <tr>
 *         <td>3</td>
 *         <td>斜体（※）</td>
 *     </tr>
 *     <tr>
 *         <td>4</td>
 *         <td>下划线（单线）</td>
 *     </tr>
 *     <tr>
 *         <td>5</td>
 *         <td>闪烁（慢）</td>
 *     </tr>
 *     <tr>
 *         <td>6</td>
 *         <td>闪烁（快）（※）</td>
 *     </tr>
 *     <tr>
 *         <td>7</td>
 *         <td>交换背景色与前景色</td>
 *     </tr>
 *     <tr>
 *         <td>8</td>
 *         <td>隐藏（伸手不见五指，啥也看不见）（※）</td>
 *     </tr>
 *     <tr>
 *         <td>30-37</td>
 *         <td>前景色，即30+x，x表示不同的颜色（参见下面的“颜色表”）</td>
 *     </tr>
 *     <tr>
 *         <td>40-47</td>
 *         <td>背景色，即40+x，x表示不同的颜色（参见下面的“颜色表”）</td>
 *     </tr>
 * </table>
 * <table>
 *     <tr>
 *         <th>颜色值</th>
 *         <td>0</td>
 *         <td>1</td>
 *         <td>2</td>
 *         <td>3</td>
 *         <td>4</td>
 *         <td>5</td>
 *         <td>6</td>
 *         <td>7</td>
 *     </tr>
 *     <tr>
 *         <th>颜色</th>
 *         <td>黑</td>
 *         <td>红</td>
 *         <td>绿</td>
 *         <td>黄</td>
 *         <td>蓝</td>
 *         <td>紫</td>
 *         <td>青</td>
 *         <td>白</td>
 *     </tr>
 * </table>
 */
public class ConsoleColor {
    public static String DEFAULT = "\u001b[0m"; // 恢复默认

    public static String FG_RED = "\u001b[1;31m"; // 前景色，加粗，红色
    public static String FG_GREEN = "\u001b[1;32m"; // 前景色，加粗，绿色
    public static String FG_YELLOW = "\u001b[1;33m"; // 前景色，加粗，黄色
    public static String FG_BLUE = "\u001b[1;34m"; // 前景色，加粗，蓝色
    public static String FG_PURPLE = "\u001b[1;35m"; // 前景色，加粗，紫色
    public static String FG_CYAN = "\u001b[1;36m"; // 前景色，加粗，青色

    public static String BG_RED = "\u001b[41m"; // 背景色，红色
    public static String BG_GREEN = "\u001b[42m"; // 背景色，绿色
    public static String BG_YELLOW = "\u001b[43m"; // 背景色，黄色
    public static String BG_BLUE = "\u001b[44m"; // 背景色，蓝色
    public static String BG_PURPLE = "\u001b[45m"; // 背景色，紫色
    public static String BG_CYAN = "\u001b[46m"; // 背景色，青色

    public static void main(String[] args) {
        System.out.println(FG_RED + "he" + BG_CYAN + "llo" + DEFAULT );
    }
}
