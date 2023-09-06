package cn.edu.lcu.cs.design_pattern.adapter.csv_loader;

import lombok.extern.java.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 文本文件加载器，读取文本文件中所有的行，返回字符串列表，一行一个字符串。
 *
 * @author ling
 * @date 2022/10/23 0:07
 */
@Log
public class TxtFileLoaderImpl implements TxtFileLoader {
    private String filename;
    private Path path;

    public TxtFileLoaderImpl(String filename) {
        URL url = TxtFileLoaderImpl.class.getClassLoader().getResource(filename);
        if (url == null) {
            throw new IllegalArgumentException("文件不存在：" + filename);
        }
        try {
            Path path = Paths.get(url.toURI());
            if (Files.exists(path)) {
                this.path = path;
                this.filename = filename;
            }
        } catch (URISyntaxException e) {
            log.warning("文件名格式不对或不存在！");
        }
    }

    @Override
    public List<String> load() {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            log.warning("文件加载失败");
            return null;
        }
    }
}
