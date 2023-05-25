package cn.edu.lcu.cs.javaprogramming.thread.producer_consumer;

import lombok.Builder;
import lombok.Data;

/**
 * 生产-消费的产品类
 *
 * @author ling
 * @date 2022/5/30 22:26
 */
@Data
@Builder
public class Product {
    private Long id;
    private String productName;
    private Integer unitPrice;
}
