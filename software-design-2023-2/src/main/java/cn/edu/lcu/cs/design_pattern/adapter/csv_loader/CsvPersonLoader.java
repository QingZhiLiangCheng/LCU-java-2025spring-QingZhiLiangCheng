package cn.edu.lcu.cs.design_pattern.adapter.csv_loader;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 从CSV文件中加载人员信息。
 * 系统已有现成的文本文件加载器，不需要重新造轮子了。
 * 可以使用适配器模式，聚合TxtFileLoader，从文件中加载所有文本，然后进一步解析为人员列表。
 *
 * 2022/10/23 16:14
 *
 * @Author ling
 */
public class CsvPersonLoader implements PersonLoader {
    private TxtFileLoader txtFileLoader;

    public CsvPersonLoader(TxtFileLoader txtFileLoader) {
        this.txtFileLoader = txtFileLoader;
    }

    /**
     * 加载人员信息
     *
     * @return
     */
    @Override
    public List<Person> load() {
        return txtFileLoader.load().stream()
                .skip(1)
                .map(CsvPersonLoader::parse)
                .collect(Collectors.toList());
    }

    /**
     * 将一行逗号分隔的数据解析为一个Person对象
     * 序号,学号,姓名,性别,班级,,
     * 1,2020204004,张三,女,2020级软件工程03班,,
     *
     * @param line
     * @return
     */
    private static Person parse(String line) {
        Person person = null;
        if (line != null) {
            String[] fields = line.split(",");
            if (fields.length > 3) {
                person = new Person();
                person.setId(Long.parseLong(fields[0]));
                person.setName(fields[2]);
            }
        }
        return person;
    }
}
