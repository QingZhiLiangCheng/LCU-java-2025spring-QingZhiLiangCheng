package cn.edu.lcu.cs.design_pattern.observer.property_listener;

/**
 * 使用以下两个类监听对象属性的变化
 * java.beans.PropertyChangeEvent
 * java.beans.PropertyChangeListener
 */
public class Client {
    public static void main(String[] args) {
        Plain plain = new Plain(); // 被观察对象，属性的变化被监听
        Lion lion = new Lion(); // 观察者，监听其它对象属性的变化
        // 为被监听对象添加属性变更监听器
        plain.addPropertyChangeListener("season", lion);

        plain.change(); // 状态变更时，被监听器监听到
        plain.change();
    }
}
