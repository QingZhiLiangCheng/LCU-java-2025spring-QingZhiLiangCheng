package cn.edu.lcu.cs.architecture.event.demo;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>事件分发器线程</p>
 * <ol>
 *     <li>事件源线程模拟触发的事件添加到事件队列中</li>
 *     <li>分发器线程持续从队列中取出事件，并分发到对应的监听器进行处理</li>
 * </ol>
 */
public class EventDispatcher extends Thread {
    /**
     * <li>事件队列，先进先出</li>
     * <li>事件源产生的事件将被插入到队列中</li>
     * <li>队列中的事件将被依次分发到注册的事件监听器进行处理</li>
     */
    private Queue<Event> eventsQueue;
    /**
     * <li>事件类型-->事件监听器 的映射</li>
     * <li>如此设计，限定了一种事件最多只有一个监听器</li>
     */
    private Map<Event.Type, EventListener> listeners;
    /**
     * 如果允许一个事件有多个监听器，可以这样设计监听器列表
     */
    // private Map<Event.Type, List<EventListener>> listeners;

    /**
     * 事件分发器应该只有一个实例，按单模式设计
     */
    private static EventDispatcher instance = new EventDispatcher();

    public static EventDispatcher getInstance() {
        return instance;
    }

    private EventDispatcher() {
        // LinkedList 间接实现了Queue接口，线程不安全，进出队列的操作需要加锁
        this.eventsQueue = new LinkedList<>();

        // ConcurrentLinkedQueue 是线程安全的队列，可以不必关心线程同步的问题
//        this.eventsQueue = new ConcurrentLinkedQueue<>();

        this.listeners = new HashMap<>();
    }

    public void addEventListener(Event.Type type, EventListener listener) {
        listeners.put(type, listener);
    }

    public void enQueue(Event event) {
        // 在队列操作时给队列加一把锁，防止出现线程同步问题
        synchronized (eventsQueue) {
            eventsQueue.add(event);
        }
    }

    @Override
    public void run() {
        Event event = null;
        while (true) {
            if (!eventsQueue.isEmpty()) {
                // 如果队列非空，取出第一个事件并分发到监听器
                // 在队列操作时给队列加一把锁，防止出现线程同步问题
                synchronized (eventsQueue) {
                    event = eventsQueue.poll(); // 取出第一个事件
                }
                // 根据事件类型，从监听器映射中查找到对应的事件监听器，并分发事件
                listeners.get(event.getType()).process(event);
            } else {
                // 如果队列为空，休眠一秒钟，再进入下次循环
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
