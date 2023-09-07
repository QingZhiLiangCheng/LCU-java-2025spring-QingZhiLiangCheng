package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory;

public class XxxDellComputer extends DellComputer {
    public XxxDellComputer() {
        super();
        setModel("XxxDellComputer");
        setCpu("第11代智能英特尔® 酷睿™ i5-11400处理器");
        setDisk("512GB M.2 PCIe NVMe 固态硬盘");
        setOs("Windows 10 家庭单语言版");
        setMemory("8GB, 8Gx1, DDR4, 2933MHz");

    }
}
