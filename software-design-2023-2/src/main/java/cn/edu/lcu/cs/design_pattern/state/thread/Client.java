package cn.edu.lcu.cs.design_pattern.state.thread;

public class Client {
    public static void main(String[] args) {
        ThreadContext thread = new ThreadContext();
        thread.start();
        thread.getCPU();
        thread.suspend();
        thread.resume();
        thread.stop();
        thread.getCPU();
    }
}
