package cn.edu.lcu.cs.basic.relationship.aggregation;

import lombok.Data;

/**
 * @description: 聚合关系举例：雇员，部分
 * @author: ling
 * @since: 2021-08-24 10:26
 **/
@Data
public class Employee {
    private Long id;
    private String name;
    private Company company;
}
