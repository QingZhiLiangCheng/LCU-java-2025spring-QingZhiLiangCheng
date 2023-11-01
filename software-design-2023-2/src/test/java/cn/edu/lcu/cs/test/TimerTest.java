package cn.edu.lcu.cs.test;

import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private static int cnt;

    /**
     * JUnit不支持多线程测试，只好用传统的main方法测试多线程。
     * 若要用junit测试多线程，就要让主线程休眠一段时间，等分线程结束之后主线程再结束。
     *
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Instant.now());
                cnt++;
                if (cnt == 5) {
                    timer.cancel();
                }
            }
        }, 1000, 1000);
    }
}
