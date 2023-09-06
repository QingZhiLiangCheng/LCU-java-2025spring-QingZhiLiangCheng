package cn.edu.lcu.cs.design_pattern.builder.bike;

import lombok.Data;

/**
 * @version v1.0
 * @ClassName: Bike
 * @Description: 产品对象
 * @Author: 黑马程序员
 */
@Data
public class Bike {
    /**
     * 品牌
     */
    private String brand;

    private String frame;//车架

    private String seat;//车座

}
