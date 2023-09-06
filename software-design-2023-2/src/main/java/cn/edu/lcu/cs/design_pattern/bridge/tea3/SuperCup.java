package cn.edu.lcu.cs.design_pattern.bridge.tea3;

public class SuperCup extends Cup {

    public SuperCup(Tea tea, DrinkTemp temp) {
        super(tea, temp);
        setFactor(1.5); // 大杯价格系数为1.5
        setDescription("大杯");
    }
}
