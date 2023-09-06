package cn.edu.lcu.cs.design_pattern.strategy.payment.another;

/**
 * 人民币现金支付
 */
public class RMBCashPayment implements PaymentStrategy {
    @Override
    public void pay(PaymentContext context) {
        // 从环境类中拉取所需的数据
        System.out.println("支付现金 ￥" + context.getMoney() + "元\t给" + context.getPayee());
    }
}
