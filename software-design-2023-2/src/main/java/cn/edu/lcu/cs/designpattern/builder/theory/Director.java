package cn.edu.lcu.cs.designpattern.builder.theory;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-07 15:19
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        return builder.getProduct();
    }

}
