package cn.edu.lcu.cs.design_pattern.factory.mobile;

public abstract class HuaweiMobile extends Mobile {
    public HuaweiMobile(String model, Double price, String description) {
        super("华为", model, price, description);
    }
}
