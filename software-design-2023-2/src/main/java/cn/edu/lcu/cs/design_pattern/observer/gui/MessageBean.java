package cn.edu.lcu.cs.design_pattern.observer.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageBean {

    /**
     * Bean的一个属性，当其值变化时触发【PropertyChangeEvent】事件
     */
    private String message;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String newValue) {
        String oldValue = this.message;
        this.message = newValue;
        // 触发属性修改事件
        support.firePropertyChange("message", oldValue, newValue);
    }
}