package cn.edu.lcu.cs.designpattern.state.thread;

/**
 * <li>就绪状态子类</li>
 * <li>根据当前状态及操作，创建不同的状态对象，进行状态转换</li>
 */
public class Ready extends ThreadState {
    public Ready() {
        stateName = "就绪状态";
        System.out.println(stateName);
    }

    public void getCPU(ThreadContext context) {
        System.out.print("调用getCPU()-->");
        //  创建新状态对象，并进行状态转换
        context.setState(new Running());
    }
}
