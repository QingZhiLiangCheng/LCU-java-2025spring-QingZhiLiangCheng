package cn.edu.lcu.cs.design_pattern.builder.computer2;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder Pattern示例：电脑组装，控制台演示程序
 */
public class Client {
    public static void main(String[] args) {
        // 创建Builder
        ComputerBuilder builder = new DellBuilder();
        // 将Builder与指挥绑定
        Director director = new Director(builder);

        // 获取电脑的配置清单
        Map<String, String> config = getConfig();

        // 根据配置单创建电脑
        director.construct(config);
        Computer computer = director.getComputer();
        System.out.println(computer);
    }

    /**
     * 获取电脑的配置清单
     *
     * @return
     */
    private static Map<String, String> getConfig() {
        // 创建电脑的配置单
        Map<String, String> config = new HashMap<>();
        config.put("cpu", "第十代智能英特尔® 酷睿™ i7-10700F 处理器");
        config.put("memory", "8GB, 8Gx1, DDR4, 2933MHz");
        config.put("disk", "512GB M.2 PCIe NVMe 固态硬盘");
        config.put("videoCard", "NVIDIA® GeForce® GT™ 730 2GB GDDR5");
        config.put("display", "27英寸微边框显示器 S2719H");
        config.put("os", "Windows 10 家庭单语言版");
        return config;
    }
}
