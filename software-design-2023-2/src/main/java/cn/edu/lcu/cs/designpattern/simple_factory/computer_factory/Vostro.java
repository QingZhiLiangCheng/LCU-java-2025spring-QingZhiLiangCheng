package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory;

/**
 * @Description 特定型号戴尔电脑
 * @Author Ling
 * @Date 2021/9/3 19:57
 * @Version 1.0
 */
public class Vostro extends DellComputer {
    public Vostro() {
        super();
        setModel("Vostro 成就紧凑型台式机");
        setCpu("英特尔® 奔腾™ 金牌G-6405处理器");
        setDisk("1TB 7200RPM 3.5英寸 SATA 硬盘");
        setOs("Windows 10 家庭单语言版");
        setMemory("4GB, 4Gx1, DDR4, 2666MHz");
    }
}
