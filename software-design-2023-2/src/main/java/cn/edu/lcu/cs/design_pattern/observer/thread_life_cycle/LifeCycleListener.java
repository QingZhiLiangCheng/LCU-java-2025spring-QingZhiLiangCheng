package cn.edu.lcu.cs.design_pattern.observer.thread_life_cycle;


public interface LifeCycleListener {

    public void onEvent(ObservableRunnable.RunnableEvent event);
    
}