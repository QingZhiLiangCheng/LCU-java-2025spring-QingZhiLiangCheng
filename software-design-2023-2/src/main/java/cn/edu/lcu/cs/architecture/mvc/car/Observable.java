package cn.edu.lcu.cs.architecture.mvc.car;


public interface Observable {
    public void notifyObservers();

    public void register(Observer obs);
}
