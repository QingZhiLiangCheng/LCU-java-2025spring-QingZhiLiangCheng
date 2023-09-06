package cn.edu.lcu.cs.architecture.event.demo;

import java.util.Random;

/**
 * 键盘事件源
 */
public class Key extends EventSource {

    public Key(EventDispatcher dispather) {
        super(dispather);
    }

    /**
     * 随机生成键盘事件
     *
     * @return
     */
    private KeyEvent generateEvent() {
        KeyEvent event = new KeyEvent("键盘事件");
        Random random = new Random();
        // 随机生成英文大写字母
        char randomChar = (char) (random.nextInt(26) + 0x41);
        event.setCharacter(randomChar);
        event.setEventSource(this);
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
