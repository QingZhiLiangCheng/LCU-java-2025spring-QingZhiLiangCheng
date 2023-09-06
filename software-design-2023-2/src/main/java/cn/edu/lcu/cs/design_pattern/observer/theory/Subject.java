package cn.edu.lcu.cs.design_pattern.observer.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题，抽象目标，抽象可被观察者。
 */
public abstract class Subject {
    /**
     * 关注本对象的观察者列表。
     */
    protected List<Observer> observers = new ArrayList<>();

    /**
     * <p>添加新观察者</p>
     *
     * @param observer
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * <p>删除观察者</p>
     *
     * @param observer
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * <p>通知所有的观察者</p>
     */
    public abstract void notifyObservers();


}
