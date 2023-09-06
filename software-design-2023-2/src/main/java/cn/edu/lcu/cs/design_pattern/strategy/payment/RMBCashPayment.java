package cn.edu.lcu.cs.design_pattern.strategy.payment;

/**
 * 人民币现金支付
 */
public class RMBCashPayment implements PaymentStrategy {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("支付现金 ￥" + context.getSalary() + "元\t给" + context.getPayee());
    }
}
