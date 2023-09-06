package cn.edu.lcu.cs.design_pattern.builder.computer_factory;

/**
 * @description: Vostro的工厂类，先创建缺省的实例，再依次设置各种属性，组装各个部件。
 * @author: ling
 * @since: 2021-09-07 16:35
 **/
public class VostroFactory implements ComputerFactory {
    /**
     * 工厂类负责制定电脑的组装流程
     *
     * @return
     */
    @Override
    public Computer build() {
        Vostro vostro = new Vostro();
        vostro.setModel("Vostro 成就紧凑型台式机");
        vostro.setCpu("英特尔® 奔腾™ 金牌G-6405处理器");
        vostro.setDisk("1TB 7200RPM 3.5英寸 SATA 硬盘");
        vostro.setOs("Windows 10 家庭单语言版");
        vostro.setMemory("4GB, 4Gx1, DDR4, 2666MHz");
        return vostro;
    }

    /**
     * 生产装配主板
     * 某些部件，比如电脑主板，生产装配比较复杂，应该设计为独立的方法.
     */
    public void buildMainBoard() {
        // 代码略
    }
}
