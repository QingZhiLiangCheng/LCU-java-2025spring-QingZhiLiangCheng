package cn.edu.lcu.cs.architecture.event.demo;

import java.util.Random;

/**
 * 定时器事件源
 */
public class Timer extends EventSource {

    public Timer(EventDispatcher dispather) {
        super(dispather);
    }

    /**
     * 随机生成定时器事件，倒计时秒数随机生成。
     *
     * @return
     */
    private TimerEvent generateEvent() {
        TimerEvent event = new TimerEvent("定时器事件");
        // 随机生成倒计时秒数
        event.setElapseSeconds(new Random().nextInt(50));
        return event;
    }

    @Override
    public void run() {
        while (true) {
            // 模拟产生一次事件，并添加到事件分发器的队列中
            dispather.enQueue(generateEvent());
            doze(); // 随机休眠若干毫秒
        }
    }
}
