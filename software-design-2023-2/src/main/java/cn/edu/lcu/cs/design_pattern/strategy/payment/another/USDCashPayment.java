package cn.edu.lcu.cs.design_pattern.strategy.payment.another;

/**
 * 美元现金支付
 */
public class USDCashPayment implements PaymentStrategy {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("支付现金 $" + context.getMoney() + "元\t给" + context.getPayee());
    }
}
