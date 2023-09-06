package cn.edu.lcu.cs.design_pattern.builder.computer_factory;

/**
 * @description: 生产特定型号的产品。
 * todo 为每种特定型号的电脑设计一条生产线似乎不太现实。
 * @author: ling
 * @since: 2021-09-07 16:37
 **/
public class OptiPlex3080Factory implements ComputerFactory {
    /**
     * 具体工厂负责电脑的装配
     * 装配流程在接口中并没有定义，所以不同工厂的装配流程可由程序员自（hu）由（luan）发挥。
     *
     * @return
     */
    @Override
    public Computer build() {
        OptiPlex3080 optiPlex3080 = new OptiPlex3080();
        optiPlex3080.setModel("OptiPlex3080");
        optiPlex3080.setDisk("2.5 英寸 500GB 7200rpm 硬盘");
        optiPlex3080.setCpu("第十代智能英特尔®奔腾™ G6405T");
        // 麒麟操作系统
        optiPlex3080.setOs("NeoKylin OS");
        optiPlex3080.setMemory("4GB");
        optiPlex3080.setKey("戴尔 有线键盘 KB216 黑色");
        optiPlex3080.setMouse("Dell USB 光电鼠标 -MS116 - 黑色");
        return optiPlex3080;
    }

    /**
     * 生产装配主板
     * 某些部件，比如电脑主板，生产装配比较复杂，应该设计为独立的方法。
     * 这些方法在工厂接口中没有定义，在具体工厂类中可由程序员自（hu）由（luan）发挥。
     * 哪些部件的装配应该独立为方法，这些方法签名如何定义，都是自（hu）由（luan）的。
     */
    public void buildMotherBoard() {
        // 代码略
    }
}
