package cn.edu.lcu.cs.architecture.pipe.updatefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.Pipe;

/**
 * <p>读取文件内容到管道</p>
 */
public class FileReaderFilter extends Thread {
    protected Pipe downPipe; // 下游管道
    private String filename;

    public FileReaderFilter(String filename, Pipe downPipe) {
        this.downPipe = downPipe;
        this.filename = filename;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String line = null;
            while ((line = reader.readLine()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
