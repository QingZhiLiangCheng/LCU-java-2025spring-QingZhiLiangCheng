package cn.edu.lcu.cs.anti_pattern.naming_rules;

public class Connect {
    /**
     * 行注释应该在代码之前，而不是行尾。
     * 变量命名尽量见名知义，不要过度简写，除非像PI这样的标准简写。
     */
    int p[];//连接容器
    int m;//连接池容量
    int n = 0;//有多少个连接正在使用

    public Connect() {
        p = new int[15];
        for (int i = 0; i < 15; i++) {
            p[i] = 0;//0表示没有被使用
        }
        m = 15;
    }

    public Connect(int n) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = 0;
        }
        m = n;
    }

    int apply()//返回连接的下标，-1表示连接池满
    {
        int i;
        for (i = 0; i < m; i++) {
            if (p[i] == 0) {
                p[i] = 1;
                return i;
            }
        }
        return -1;
    }

    /**
     * 每种语言都有自己的编程规范。give_Back这个方法名称就不如giveBack好。
     * @param n
     */
    void give_Back(int n) {
        p[n] = 0;
    }

    void print() {
        for (int i = 0; i < m; i++) {
            if (p[i] == 1) {
                // 用printf更好一些。
                System.out.println("第" + (i + 1) + "个连接正在使用");
            }
        }
    }

}
