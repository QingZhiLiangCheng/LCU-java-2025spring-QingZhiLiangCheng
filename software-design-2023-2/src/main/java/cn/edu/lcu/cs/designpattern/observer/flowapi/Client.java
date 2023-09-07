package cn.edu.lcu.cs.designpattern.observer.flowapi;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        CountPublisher publisher = new CountPublisher(500);
        CountSubscriber subscriber = new CountSubscriber(15);
        publisher.subscribe(subscriber);
        Thread.currentThread().join();

    }
}
