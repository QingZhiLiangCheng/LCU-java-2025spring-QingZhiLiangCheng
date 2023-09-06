package cn.edu.lcu.cs.architecture.event.theory;

public abstract class Event {
    private Object eventSource;

    public Event(Object eventSource) {
        this.eventSource = eventSource;
    }
}
