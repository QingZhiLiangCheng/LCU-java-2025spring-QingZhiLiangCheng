package cn.edu.lcu.cs.javaprogramming.io;

import lombok.Cleanup;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 文件工具类
 *
 * @author ling
 * @date 2022/4/25 20:42
 */
public class FileUtil {

    public static final String CLASSPATH = "classpath:";

    /**
     * 根据文件名，获取文件对象。
     *
     * @param filename 文件名，可以是普通路径格式，也可以是带【classpath:】前缀的类路径格式。
     * @return
     */
    public static File getFile(String filename) {
        File file = null;
        if (filename != null && !filename.trim().isEmpty()) {
            // 去除头尾空白符
            filename = filename.trim();
            if (filename.toLowerCase().startsWith(CLASSPATH)) {
                // 类路径格式
                // 剔除前缀 classpath:
                filename = filename.substring(CLASSPATH.length());
                URL url;
                if (filename.startsWith("/")) {
                    // 类路径以 / 起始
                    url = FileUtil.class.getResource(filename);
                } else {
                    // 类路径不以 / 起始
                    url = FileUtil.class.getClassLoader().getResource(filename);
                }

                try {
                    file = new File(url.toURI());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            } else {
                // 普通路径格式
                file = new File(filename);
            }
        }
        return file;
    }

    /**
     * 模仿命令行列目录命令
     *
     * @param path
     */
    public static void dir(String path) throws IOException {
        // 将字符串形式的路径转换为File对象
        File file = getFile(path);
        dir(file);
    }

    /**
     * 模仿命令行列目录命令
     *
     * @param file
     * @throws IOException
     */
    public static void dir(File file) throws IOException {
        if (file.exists()) {
            // 无论文件还是目录，先打印自身的规范路径
            System.out.println(file.getCanonicalFile());
            if (file.isDirectory()) {
                // 如果是目录，则递归遍历目录中所有的文件与子目录
                for (File item : file.listFiles()) {
                    dir(item);
                }
            }
        }
    }

    /**
     * 文件复制
     *
     * @param srcFileName 源文件名
     * @param dstFileName 目标文件或目录名
     * @return 复制的字节数
     */
    public static int copy(String srcFileName, String dstFileName) throws IOException {
        // 复制的字节数
        int byteAmount = 0;
        File srcFile = getFile(srcFileName);
        if (srcFile.exists()) {
            File dstFile = getFile(dstFileName);
            if (!dstFile.exists()) {
                // 如果目标目录不存在，就创建它
                dstFile.mkdirs();
            }
            if (dstFile.isDirectory()) {
                // 如果目标是目录，以它为父目录创建新的文件对象，文件名与原始名称相同
                dstFile = new File(dstFile, srcFile.getName());
            }
            //程序运行到这里，无论目标是文件还是目录，无论存在不存在，目标文件dstFile已经准备就绪
            byte[] buffer = new byte[1024];
            @Cleanup
            BufferedInputStream ins = new BufferedInputStream(new FileInputStream(srcFile));
            @Cleanup
            BufferedOutputStream outs = new BufferedOutputStream(new FileOutputStream(dstFile));
            int readLength = 0;
            while ((readLength = ins.read(buffer)) != -1) {
                outs.write(buffer, 0, readLength);
                byteAmount += readLength;
            }
        }
        return byteAmount;
    }
}
