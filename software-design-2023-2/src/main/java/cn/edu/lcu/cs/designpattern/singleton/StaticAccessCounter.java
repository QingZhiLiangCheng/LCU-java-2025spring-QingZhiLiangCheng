package cn.edu.lcu.cs.designpattern.singleton;


/**
 * 使用静态成员保存访问计数，使用静态方法修改计数，不用创建实例。
 */
public class StaticAccessCounter {
    /**
     * 使用静态成员保存访问计数，不用创建实例。
     */
    private static long cnt = 0;

    /**
     * 修改计数器，别忘了加锁。
     *
     * @return
     */
    public synchronized static long access() {
        // 既然加了锁，就让加锁后的代码尽量简洁，操作尽快完成，别让别的线程长久等待。
        return ++cnt;
    }

    /**
     * 在修改与返回计数器之间插入休眠，给制造线程同步问题一点点时间，不然不容易演示失败的情况。
     * 纯粹为了演示失败的情况才这样写，正确的操作应该是上边那个方法。
     */
//    public /* synchronized */ static long access() {
//        cnt = cnt + 1;
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return cnt;
//    }
}
