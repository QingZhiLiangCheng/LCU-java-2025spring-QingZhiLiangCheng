package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory;

/**
 * @Description 特定型号戴尔电脑
 * @Author Ling
 * @Date 2021/9/3 19:57
 * @Version 1.0
 */
public class XPS extends DellComputer {
    public XPS() {
        super();
        setModel("XPS 紧凑型台式机");
        setCpu("第11代智能英特尔® 酷睿™ i5-11400处理器");
        setDisk("512GB M.2 PCIe NVMe 固态硬盘");
        setOs("Windows 10 家庭单语言版");
        setMemory("8GB, 8Gx1, DDR4, 2933MHz");
    }
}
