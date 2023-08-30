package cn.edu.lcu.cs.softwaredesign.util;

import java.util.stream.Stream;

public class StackTraceUtil {
    public static void printStackTrace() {
        System.out.println("---------------------- Stack Trace -------------------------");
        Stream.of(Thread.currentThread().getStackTrace()).forEach(System.out::println);
        System.out.println("---------------------- Stack Trace -------------------------");
        // 打印调用栈，显示方法间的调用关系
//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element : stackTrace) {
//            System.out.println(element.getClassName() + "." +  element.getMethodName() + "()");
//        }
    }

    /**
     * 打印当前调用的方法
     */
    public static void printMethodInvokeInfo() {
        System.out.println(Thread.currentThread().getStackTrace()[2]);
    }
}
