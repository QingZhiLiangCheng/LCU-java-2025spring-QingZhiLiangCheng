package cn.edu.lcu.cs.architecture.event.theory;

/**
 * 事件对象
 */
public class EventObject implements java.io.Serializable {
    private static final long serialVersionUID = 5516075349620653480L;

    /**
     * The object on which the Event initially occurred.
     */
    protected transient Object source;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public EventObject(Object source) {
        if (source == null)
            throw new IllegalArgumentException("null source");

        this.source = source;
    }

    /**
     * The object on which the Event initially occurred.
     *
     * @return the object on which the Event initially occurred
     */
    public Object getSource() {
        return source;
    }

    /**
     * Returns a String representation of this EventObject.
     *
     * @return a String representation of this EventObject
     */
    public String toString() {
        return getClass().getName() + "[source=" + source + "]";
    }
}
