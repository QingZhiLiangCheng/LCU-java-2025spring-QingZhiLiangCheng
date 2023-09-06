package cn.edu.lcu.cs.design_pattern.state.thread.another;

public class Client {
    public static void main(String[] args) {
        ThreadContext thread = new ThreadContext();
        thread.start();
        thread.stop();
        thread.getCPU();
        thread.suspend();
        thread.resume();
        thread.getCPU();
    }
}
