package cn.edu.lcu.cs.design_pattern.observer.theory;

/**
 * 具体主题，被观察的对象。
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObservers() {
        System.out.println(getClass().getSimpleName() + " 发生状态改变");
        observers.forEach(Observer::response);
    }
}
