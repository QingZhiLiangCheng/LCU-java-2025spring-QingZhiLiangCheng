package cn.edu.lcu.cs.designpattern.strategy.log;

import java.util.Random;

public class DBConnection {
    public static DBConnection getInstance() {

        // 故意制造异常，1/5的异常概率
        Random random = new Random();
        if (random.nextInt(5) == 3) {
            throw new RuntimeException("数据库连接失败");
        }

        return new DBConnection();
    }
}
