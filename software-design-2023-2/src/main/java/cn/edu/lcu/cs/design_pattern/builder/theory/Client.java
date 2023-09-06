package cn.edu.lcu.cs.design_pattern.builder.theory;

/**
 * @author ling
 * @date 2022/9/5 9:47
 */
public class Client {
    public static void main(String[] args) {
        Builder builder1 = new ConcreteBuilder1();
        Director director = new Director(builder1);
        Product product1 = director.construct();
        System.out.println(product1);

        Builder builder2 = new ConcreteBuilder2();
        director = new Director(builder2);
        Product product2 = director.construct();
        System.out.println(product2);

    }
}
