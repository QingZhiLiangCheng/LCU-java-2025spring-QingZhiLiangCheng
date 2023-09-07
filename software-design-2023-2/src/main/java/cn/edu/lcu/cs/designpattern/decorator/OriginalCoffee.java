package cn.edu.lcu.cs.designpattern.decorator;

/**
 * 原始咖啡
 *
 * @author ling
 * @date 2022/9/25 23:56
 */
public class OriginalCoffee implements Coffee {
    @Override
    public void makeCoffee() {
        System.out.print("原味咖啡");
    }
}
