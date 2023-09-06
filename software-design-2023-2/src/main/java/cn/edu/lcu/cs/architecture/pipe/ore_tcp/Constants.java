package cn.edu.lcu.cs.architecture.pipe.ore_tcp;

/**
 * @Author Ling
 * @Date 2021/11/27 22:55
 * @Version 1.0
 */
public class Constants {
    public static int SOCKET_PORT_MINE = 9000;
    public static int SOCKET_PORT_GRADE_SPECIAL = 9001;
    public static int SOCKET_PORT_GRADE_ONE = 9002;
    public static int SOCKET_PORT_GRADE_TWO = 9003;
    public static int SOCKET_PORT_GRADE_UNGRADED = 9004;
    public static int SOCKET_PORT_GRADE_WASTE = 9005;

    public static String HOST = "localhost";

    public static void doze() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
