package cn.edu.lcu.cs.design_pattern.factory.mobile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Mobile {
    private String brand; // 品牌
    private String model; // 型号
    private Double price; // 价格
    private String description; // 简介
}
