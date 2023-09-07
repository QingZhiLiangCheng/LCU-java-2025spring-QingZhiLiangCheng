package cn.edu.lcu.cs.designpattern.builder.computer_factory;

/**
 * @Description 特定型号戴尔电脑，构造方法直接返回一个组装好的实例
 * @Author Ling
 * @Date 2021/9/3 19:57
 * @Version 1.0
 */
public class XPS extends DellComputer {
    /**
     * POJO的构造方法负责对象的创建组装，虽然灵活，但是创建过程无法复用。
     */
    public XPS() {
        super();
        setModel("XPS 紧凑型台式机");
        setCpu("第11代智能英特尔® 酷睿™ i5-11400处理器");
        setDisk("512GB M.2 PCIe NVMe 固态硬盘");
        setOs("Windows 10 家庭单语言版");
        setMemory("8GB, 8Gx1, DDR4, 2933MHz");
    }
}
