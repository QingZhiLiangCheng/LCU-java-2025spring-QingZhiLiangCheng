package cn.edu.lcu.cs.design_pattern.observer.property_listener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 草原类，被观察（监听）的对象
 */
public class Plain {
    private Season season;

    /**
     * 对属性变更的监听进行支持
     */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Plain() {
        this.season = Season.DRY;
    }

    public Season getSeason() {
        return season;
    }

    /**
     * 属性的变更
     *
     * @param season
     */
    public void setSeason(Season season) {
        // 当属性变更时，触发一次属性变更事件，包括属性名称、旧值与新值
        // 注意属性名称不要写错了，大小写敏感。
        propertyChangeSupport.firePropertyChange("season", this.season, season);
        this.season = season;

    }

    /**
     * 添加事件侦听器，当所有属性变更时都会触发事件。
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * 添加事件侦听器，只有当指定的属性值变更时才会触发事件。
     *
     * @param propertyName
     * @param listener
     */
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    /**
     * 移除事件侦听器
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }


    /**
     * 改变季节
     */
    public void change() {
        if (season == Season.DRY) {
            setSeason(Season.RAINY);
        } else {
            setSeason(Season.DRY);
        }
    }

    /**
     * 旱季，雨季
     */
    public enum Season {DRY, RAINY}
}
