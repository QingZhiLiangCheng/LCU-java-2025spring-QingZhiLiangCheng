package cn.edu.lcu.cs.designpattern.mediator.estateagent;

/**
 * 房产中介公司的客户
 */
public abstract class Customer {
    private String name;

    public String getName() {
        return name;
    }

    public Customer(String name) {
        this.name = name;
    }

}
