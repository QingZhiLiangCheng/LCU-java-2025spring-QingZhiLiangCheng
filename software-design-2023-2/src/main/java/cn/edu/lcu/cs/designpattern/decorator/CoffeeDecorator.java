package cn.edu.lcu.cs.designpattern.decorator;

/**
 * 咖啡装饰者抽象基类
 *
 * @author ling
 * @date 2022/9/25 23:57
 */
public abstract class CoffeeDecorator implements Coffee {
    /**
     * 被装饰的对象
     */
    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void makeCoffee() {
        coffee.makeCoffee();
    }
}
