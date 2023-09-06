package cn.edu.lcu.cs.design_pattern.observer.property_change_listener;

import lombok.Getter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 被观察对象，当其某些属性变化时，触发事件。
 *
 * @author ling
 * @date 2022/10/10 0:15
 */
@Getter
public class Person {
    private Double weight;

    private String name;

    private PropertyChangeSupport listener = new PropertyChangeSupport(this);

    public Person(String name, Double weight) {
        this.weight = weight;
        this.name = name;
    }

    /**
     * 对本属性进行观察，当其值变化时，触发事件。
     *
     * @param weight
     */
    public void setWeight(Double weight) {
        // 当改变本属性的时候，触发一次事件
        // 指定属性名称，旧值，新值
        listener.firePropertyChange("weight", this.weight, weight);
        this.weight = weight;
    }

    /**
     * 添加事件监听器。
     * 所有属性变化时都会触发事件。
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.listener.addPropertyChangeListener(listener);
    }

    /**
     * 添加事件监听器。
     * 仅当指定名称的属性值变化时才触发事件。
     *
     * @param propertyName
     * @param listener
     */
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.listener.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.listener.removePropertyChangeListener(listener);
    }
}
