package cn.edu.lcu.cs.javaprogramming.thread;

import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池与Callable线程演示。
 *
 * @author ling
 * @date 2022/5/29 22:38
 */
public class URLDownloaderClient {
    private static final String downloadFolder = "D:/download/temp";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable线程实例
        URLDownloader downloader1 = new URLDownloader("https://gitee.com/linghy/java-programming/blob/594288b68720099fede40f43dd7eb53834aca6fd/java-2022-1/src/main/java/cn/edu/lcu/cs/javaprogramming/db/DBUtil.java#L13", downloadFolder);
        URLDownloader downloader2 = new URLDownloader("http://ee-c.lcu.edu.cn/static/images/hwImages/huaweiyunLogo.png", downloadFolder);
        URLDownloader downloader3 = new URLDownloader("https://cs.lcu.edu.cn/images/content/2021-06/20210624102720513472.jpg", downloadFolder);

        // 创建线程池，固定4个线程。
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // 提交任务到线程池以供运行
        // 返回一个表示该任务待处理结果的 Future。
        // Future 的get方法将在成功完成后返回任务的结果。
        Future<Path> task1 = executorService.submit(downloader1);
        Future<Path> task2 = executorService.submit(downloader2);
        Future<Path> task3 = executorService.submit(downloader3);

        // 获取任务的返回值
        Path path1 = task1.get();
        System.out.println("path1 = " + path1);

        Path path2 = task2.get();
        System.out.println("path2 = " + path2);

        Path path3 = task3.get();
        System.out.println("path3 = " + path3);

        // 尝试停止所有正在执行的任务
        executorService.shutdownNow();

    }
}
