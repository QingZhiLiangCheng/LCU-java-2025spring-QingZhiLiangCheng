package cn.edu.lcu.cs.design_pattern.decorator;

/**
 * 加糖咖啡装饰者
 *
 * @author ling
 * @date 2022/9/25 23:59
 */
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void makeCoffee() {
        super.makeCoffee();
        addSugar();
    }

    private void addSugar() {
        System.out.print(" 加糖");
    }
}
