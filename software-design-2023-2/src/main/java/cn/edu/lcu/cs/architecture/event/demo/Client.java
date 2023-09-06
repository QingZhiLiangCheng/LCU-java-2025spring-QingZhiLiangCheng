package cn.edu.lcu.cs.architecture.event.demo;

import static cn.edu.lcu.cs.architecture.event.demo.Event.Type.*;

public class Client {
    public static void main(String[] args) {
        // 创建事件分发器线程，单例模式
        EventDispatcher dispatcher = EventDispatcher.getInstance();
        // 创建事件监听器并注册
        dispatcher.addEventListener(MOUSE, new MouseEventListener());
        dispatcher.addEventListener(KEY, new KeyEventListener());
        dispatcher.addEventListener(TIMER, new TimerEventListener());

        // 创建事件源模拟线程，持续生成事件
        Mouse mouse = new Mouse(dispatcher);
        Key key = new Key(dispatcher);
        Timer timer = new Timer(dispatcher);

        // 启动各个线程
        dispatcher.start();
        key.start();
        mouse.start();
        timer.start();
    }
}
