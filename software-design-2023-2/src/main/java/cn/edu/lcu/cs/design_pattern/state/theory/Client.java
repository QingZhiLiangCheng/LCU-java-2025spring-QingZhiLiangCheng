package cn.edu.lcu.cs.design_pattern.state.theory;

public class Client {
    public static void main(String[] args) {
        // 状态环境类，封装了状态子类及状态转换操作，客户类就不需关心具体的状态转换。
        Context context = new Context();
        while (true) {
            // 调用环境类的handle()方法引发状态转换。
            // 状态转换被封装在环境类或状态子类，客户类就不需要复杂的条件判断。
            context.handle();
        }
    }
}
