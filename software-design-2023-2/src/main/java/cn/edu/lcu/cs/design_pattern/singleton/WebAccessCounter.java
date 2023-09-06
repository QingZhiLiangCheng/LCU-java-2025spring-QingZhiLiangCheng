package cn.edu.lcu.cs.design_pattern.singleton;

public class WebAccessCounter {
    private long cnt;

    private static WebAccessCounter instance;

    private WebAccessCounter() {
        cnt = 0;
    }

    public long getCnt() {
        return cnt;
    }

    public static WebAccessCounter getInstance() {
        if (instance == null) {
            instance = new WebAccessCounter();
        }
        return instance;
    }

    public synchronized long access() {
        return ++cnt;
    }
}
