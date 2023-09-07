package cn.edu.lcu.cs.designpattern.observer.thread_life_cycle;


public interface LifeCycleListener {

    public void onEvent(ObservableRunnable.RunnableEvent event);
    
}