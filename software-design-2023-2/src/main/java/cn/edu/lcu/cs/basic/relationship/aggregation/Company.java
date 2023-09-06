package cn.edu.lcu.cs.basic.relationship.aggregation;

import lombok.Data;

import java.util.List;

/**
 * @description: 聚合关系举例：公司，整体
 * @author: ling
 * @since: 2021-08-24 10:24
 **/
@Data
public class Company {
    private Long id;
    private String name;
    private List<Employee> employees;
}
