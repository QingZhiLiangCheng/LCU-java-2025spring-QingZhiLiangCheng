package cn.edu.lcu.cs.design_pattern.state.thread;

/**
 * <p>线程环境类，持有线程状态对象</p>
 * <p>环境类负责创建状态子类的初始对象</p>
 * <p>其它状态子类对象由状态子类对象根据状态情况创建</p>
 */
public class ThreadContext {
    private ThreadState state;

    public ThreadContext() {
        // 初始状态
        state = new Newly();
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public void start() {
        if (state instanceof Newly) {
            ((Newly) state).start(this);
        } else {
            System.out.println("当前【" + state.getStateName() + "】，不能start()");
        }
    }

    public void getCPU() {
        if (state instanceof Ready) {
            ((Ready) state).getCPU(this);
        } else {
            System.out.println("当前【" + state.getStateName() + "】，不能getCPU()");
        }
    }

    public void suspend() {
        if (state instanceof Running) {
            ((Running) state).suspend(this);
        } else {
            System.out.println("当前【" + state.getStateName() + "】，不能suspend()");
        }
    }

    public void stop() {
        if (state instanceof Running) {
            ((Running) state).stop(this);
        } else {
            System.out.println("当前【" + state.getStateName() + "】，不能stop()");
        }
    }

    public void resume() {
        if (state instanceof Blocked) {
            ((Blocked) state).resume(this);
        } else {
            System.out.println("当前【" + state.getStateName() + "】，不能resume()");
        }
    }
}
