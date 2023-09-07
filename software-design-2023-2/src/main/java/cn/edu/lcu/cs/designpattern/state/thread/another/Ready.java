package cn.edu.lcu.cs.designpattern.state.thread.another;

/**
 * <li>就绪状态子类</li>
 * <li>根据当前状态及操作，创建不同的状态对象，进行状态转换</li>
 */
public class Ready extends ThreadState {
    public Ready() {
        stateName = "就绪状态";
    }

    @Override
    public void getCPU(ThreadContext context) {
        System.out.println("获得CPU时间-->运行状态");
        //  创建新状态对象，并进行状态转换
        context.setState(new Running());
    }
}
