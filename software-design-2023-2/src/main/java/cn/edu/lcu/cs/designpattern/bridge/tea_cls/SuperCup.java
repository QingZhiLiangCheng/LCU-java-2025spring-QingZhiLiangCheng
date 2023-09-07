package cn.edu.lcu.cs.designpattern.bridge.tea_cls;

public class SuperCup extends Cup {

    public SuperCup(Tea tea) {
        super(tea);
        setFactor(1.5); // 大杯价格系数为1.5
        setDescription("大杯");
    }
}
