package cn.edu.lcu.cs.designpattern.bridge.tea3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 饮料温度
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DrinkTemp {
    private String description;
}
