package cn.edu.lcu.cs.designpattern.builder.theory;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-07 15:19
 **/
public interface Builder {
    void buildPartA();

    void buildPartB();

    Product getProduct();
}
