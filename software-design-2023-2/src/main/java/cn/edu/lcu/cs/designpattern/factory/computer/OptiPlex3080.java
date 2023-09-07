package cn.edu.lcu.cs.designpattern.factory.computer;

/**
 * @Description 特定型号戴尔电脑
 * @Author Ling
 * @Date 2021/9/3 19:57
 * @Version 1.0
 */
public class OptiPlex3080 extends Computer {
    public OptiPlex3080() {
        setBrand("Dell");
        setModel("OptiPlex3080");
        setCpu("第十代智能英特尔®奔腾™ G6405T");
        setDisk("2.5 英寸 500GB 7200rpm 硬盘");
        setMemory("4GB");
    }
}
