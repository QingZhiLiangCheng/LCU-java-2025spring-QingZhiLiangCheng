package cn.edu.lcu.cs.designpattern.factory.theory;

public class ProductC implements Product {
    private String name;
    private Integer id;
    @Override
    public void print() {
        System.out.println(getClass().getName() + "\t被访问");
    }

}
