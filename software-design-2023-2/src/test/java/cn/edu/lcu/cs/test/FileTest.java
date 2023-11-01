package cn.edu.lcu.cs.test;

import org.junit.jupiter.api.Test;

import java.net.URL;

public class FileTest {
    /**
     * 读写资源文件
     */
    @Test
    void accessResources() {
        String pathname = "/car/CarFiles/Honda Accord-2005.html";
        URL resource = getClass().getResource(pathname);
        String path = resource.getPath();
        System.out.println(path);
        String file = resource.getFile();
        System.out.println(file);


    }
}
