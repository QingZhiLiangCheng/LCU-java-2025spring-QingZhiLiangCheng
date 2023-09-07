package cn.edu.lcu.cs.designpattern.adapter.csv_loader;

import java.util.List;

/**
 * 文本文件加载器：
 * 读取文本文件，将所有行读取为一个字符串列表。
 * 2022/10/23 16:06
 *
 * @Author ling
 */
public interface TxtFileLoader {
    /**
     * 加载文本文件
     * @return 所有行组成的列表
     */
    List<String> load();
}
