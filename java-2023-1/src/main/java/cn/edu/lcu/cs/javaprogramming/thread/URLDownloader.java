package cn.edu.lcu.cs.javaprogramming.thread;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;

/**
 * @author ling
 * @date 2022/5/29 22:20
 */
public class URLDownloader implements Callable<Path> {
    private URL url;
    private Path path;
    /**
     * 下载路径（文件夹）
     */
    private String downloadFolder;

    public URLDownloader(String urlString, String downloadFolder) {
        try {
            this.downloadFolder = downloadFolder;
            Path downloadPath = Path.of(downloadFolder);
            // 如果下载路径不存在，就创建它们
            if (Files.notExists(downloadPath)) {
                Files.createDirectories(downloadPath);
            }
            this.url = new URL(urlString);
            String filename = url.getFile();
            // 截取URL路径中最后的文件名
            filename = filename.substring(filename.lastIndexOf("/"));
            // 在下载路径中，以原始文件名为名称，创建路径对象。
            path = Path.of(downloadFolder, filename);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL地址错误", e);
        } catch (IOException e) {
            throw new RuntimeException("IO异常", e);
        }
    }

    @Override
    public Path call() throws Exception {
        // 从URL输入流中读取内容，存储到path指定的文件中，如果文件存在就替换。
        Files.copy(url.openStream(), path, StandardCopyOption.REPLACE_EXISTING);
        // 返回下载后的文件路径信息
        return path;
    }
}
