package cn.edu.lcu.cs.design_pattern.bridge.tea3;

public class MediumCup extends Cup {

    public MediumCup(Tea tea) {
        super(tea);
        setFactor(1.0); // 中杯价格系数为1.0
        setDescription("中杯");
    }

}
