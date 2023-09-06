package cn.edu.lcu.cs.design_pattern.simple_factory.theory;

public class ProductA implements Product {
    private String name;
    private Integer id;
    @Override
    public void print() {
        System.out.println(getClass().getName() + "\t被访问");
    }

}
