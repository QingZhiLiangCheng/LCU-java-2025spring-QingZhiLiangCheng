package cn.edu.lcu.cs.design_pattern.command.restaurant;

/**
 * @Author Ling
 * @Date 2021/10/20 8:43
 * @Version 1.0
 */
public class OrderCommand implements Command {
    private Chef chef;
    private Order order;

    @Override
    public void execute() {
        order.getCuisines().forEach(cuisine -> chef.cook(cuisine.getName()));
    }
}
