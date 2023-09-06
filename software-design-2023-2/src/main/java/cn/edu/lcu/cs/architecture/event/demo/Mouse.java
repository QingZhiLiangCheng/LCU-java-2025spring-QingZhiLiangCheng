package cn.edu.lcu.cs.architecture.event.demo;

import java.util.Random;

/**
 * 鼠标事件源
 */
public class Mouse extends EventSource {

    public Mouse(EventDispatcher dispather) {
        super(dispather);
    }

    /**
     * 随机生成几种不同的鼠标事件：【单击】, 【双击】, 【移动】
     *
     * @return
     */
    private MouseEvent generateEvent() {
        Random random = new Random();
        int rand = random.nextInt(3);
        MouseEvent event = null;
        switch (rand) {
            case 0:
                event = new MouseEvent("鼠标单击");
                break;
            case 1:
                event = new MouseEvent("鼠标双击");
                break;
            case 2:
                event = new MouseEvent("鼠标移动");
                event.setX(random.nextInt(800));
                event.setY(random.nextInt(600));
                break;
        }
        event.setEventSource(this);
        return event;
    }

    @Override
    public void run() {
        while (true) {
            // 模拟产生一次事件
            Event event = generateEvent();
            // 添加到事件分发器的队列中
            dispather.enQueue(event);
            // 随机休眠若干毫秒
            doze();
        }
    }
}
