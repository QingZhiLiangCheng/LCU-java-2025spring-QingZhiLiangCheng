package cn.edu.lcu.cs.design_pattern.observer.thread_life_cycle;

import java.util.Arrays;

public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2", "3"));
    }
}