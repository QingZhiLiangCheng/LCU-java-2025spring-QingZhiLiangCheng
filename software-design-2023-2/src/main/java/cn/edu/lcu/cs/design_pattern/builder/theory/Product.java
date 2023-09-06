package cn.edu.lcu.cs.design_pattern.builder.theory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description: 复杂产品类
 * @author: ling
 * @since: 2021-09-07 15:18
 **/
@Getter
@Setter
@ToString
public class Product {
    private String partA;
    private String partB;
}
