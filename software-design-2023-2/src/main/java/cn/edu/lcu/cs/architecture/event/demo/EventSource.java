package cn.edu.lcu.cs.architecture.event.demo;

import java.util.Random;

/**
 * <p>模拟事件源：键盘，鼠标，定时器</p>
 * <p>独立的线程，随机生成事件</p>
 */
public abstract class EventSource extends Thread {
    protected EventDispatcher dispather;

    public EventSource(EventDispatcher dispather) {
        this.dispather = dispather;
    }

    /**
     * 打盹，随机休眠若干毫秒。
     */
    public void doze() {
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
