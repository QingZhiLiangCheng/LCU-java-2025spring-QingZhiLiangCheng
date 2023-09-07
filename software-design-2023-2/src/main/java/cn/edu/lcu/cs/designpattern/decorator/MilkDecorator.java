package cn.edu.lcu.cs.designpattern.decorator;

/**
 * 牛奶咖啡装饰者
 *
 * @author ling
 * @date 2022/9/25 23:59
 */
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    private void addMilk() {
        System.out.print(" 加奶");
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addMilk();
    }
}
