package cn.edu.lcu.cs.designpattern.bridge.tea_interface;

/**
 * 中杯
 */
public class MediumCup implements CupSize {
    /**
     * 杯中茶的种类
     */
    private TeaKind kind;
    /**
     * 此种饮料杯的默认价格系数
     */
    private Double factor = 1.0;

    public MediumCup(TeaKind kind) {
        this.kind = kind;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public void setKind(TeaKind kind) {
        this.kind = kind;
    }

    /**
     * 某种茶原始售价 * 价格系数
     *
     * @return 此种茶饮料的最终售价
     */
    @Override
    public Double getPrice() {
        return kind.getPrice() * factor;
    }
}
