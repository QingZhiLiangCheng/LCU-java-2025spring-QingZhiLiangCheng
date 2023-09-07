package cn.edu.lcu.cs.designpattern.strategy.payment.cash_payment;

/**
 * 美元现金支付
 */
public class USDCashPayment implements PaymentStrategy {
    @Override
    public void pay(String payee, double salary) {
        System.out.println("支付现金 $" + salary + "元\t给" + payee);
    }
}
