package cn.edu.lcu.cs.designpattern.strategy.payment;

/**
 * 美元现金支付
 */
public class USDCashPayment implements PaymentStrategy {
    @Override
    public void pay(PaymentContext context) {
        System.out.println("支付现金 $" + context.getSalary() + "元\t给" + context.getPayee());
    }
}
