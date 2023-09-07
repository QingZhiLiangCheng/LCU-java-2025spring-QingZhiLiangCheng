package cn.edu.lcu.cs.designpattern.adapter.csv_loader;

import java.util.List;

/**
 * @author ling
 * @date 2022/10/23 0:05
 */
public interface PersonLoader {
    /**
     * 从CSV文件中加载人员信息
     *
     * @return
     */
    List<Person> load();
}
