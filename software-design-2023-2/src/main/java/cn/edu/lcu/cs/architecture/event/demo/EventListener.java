package cn.edu.lcu.cs.architecture.event.demo;

public interface EventListener {
    /**
     * 处理发生的事件
     *
     * @param event 事件分发器分发过来的事件
     */
    void process(Event event);
}
