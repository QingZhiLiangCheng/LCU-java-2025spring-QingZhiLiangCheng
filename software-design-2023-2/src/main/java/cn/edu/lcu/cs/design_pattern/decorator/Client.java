package cn.edu.lcu.cs.design_pattern.decorator;

/**
 * @author ling
 * @date 2022/9/26 0:02
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = new OriginalCoffee();
        coffee.makeCoffee();
        System.out.println();

        coffee = new MilkDecorator(coffee);
        coffee.makeCoffee();
        System.out.println();

        coffee = new SugarDecorator(coffee);
        coffee.makeCoffee();
    }
}
