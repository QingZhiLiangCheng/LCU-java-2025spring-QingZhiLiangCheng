package cn.edu.lcu.cs.designpattern.builder.computer.parameterized;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

/**
 * Builder Pattern示例：电脑组装，控制台演示程序
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 从配置文件中加载电脑配置清单
        Map<String, String> config = getConfig();

        // 创建Builder
        ComputerBuilder dellBuilder = new DellBuilder();
        dellBuilder.setConfig(config);
        // 创建指挥者，并与Builder绑定
        Director director = new Director(dellBuilder);
        // 生产装配电脑
        director.construct();
        Computer dellComputer = director.getComputer();
        System.out.println(dellComputer);

        ComputerBuilder huaweiBuilder = new HuaweiBuilder();
        huaweiBuilder.setConfig(config);
        director.setBuilder(huaweiBuilder);
        director.construct();
        Computer huaweiComputer = director.getComputer();
        System.out.println(huaweiComputer);

    }

    /**
     * 读取类路径中的配置文件，并加载到properties对象中。
     *
     * @return
     * @throws IOException
     */
    private static Map getConfig() throws IOException {
        // 配置文件路径，从类路径的根起始，即Maven项目的 src/main/resources/
        String configFile = "/designpattern/builder/computer/config.properties";
        Properties properties = new Properties();
        // 从类路径中加载配置文件
        InputStream inStream = Client.class.getResourceAsStream(configFile);
        properties.load(new InputStreamReader(inStream, "UTF-8"));
        return properties;
    }
}
