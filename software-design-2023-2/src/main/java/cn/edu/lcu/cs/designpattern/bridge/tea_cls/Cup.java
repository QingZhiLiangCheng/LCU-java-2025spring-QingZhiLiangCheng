package cn.edu.lcu.cs.designpattern.bridge.tea_cls;

import lombok.Data;
import lombok.ToString;

/**
 * 饮料杯，分大中小几类
 */
@Data
public abstract class Cup {
    /**
     * 杯中茶的类型
     */
    private Tea tea;
    private Double factor;
    private String description;

    public Cup(Tea tea) {
        this.tea = tea;
    }

    /**
     * 中杯价格系数1.0，即某种茶售价的1.0倍
     *
     * @return
     */
    @ToString.Include
    public Double getPrice() {
        return tea.getPrice() * factor;
    }
}
