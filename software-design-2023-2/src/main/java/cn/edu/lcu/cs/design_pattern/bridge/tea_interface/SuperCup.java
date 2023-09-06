package cn.edu.lcu.cs.design_pattern.bridge.tea_interface;

public class SuperCup implements CupSize {
    private TeaKind kind;
    private Double factor = 1.5; // 大杯价格系数

    public SuperCup(TeaKind kind) {
        this.kind = kind;
    }

    public void setKind(TeaKind kind) {
        this.kind = kind;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public SuperCup() {
    }

    /**
     * 某种茶原始售价 * 价格系数
     *
     * @return
     */
    @Override
    public Double getPrice() {
        return kind.getPrice() * factor;
    }
}
