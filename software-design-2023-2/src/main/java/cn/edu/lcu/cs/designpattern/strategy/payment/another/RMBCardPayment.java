package cn.edu.lcu.cs.designpattern.strategy.payment.another;

/**
 * 人民币银行卡支付
 */
public class RMBCardPayment implements PaymentStrategy {
    @Override
    public void pay(PaymentContext context) {
        CardPaymentContext cardPaymentContext = (CardPaymentContext) context;
        System.out.println("支付 ￥" + context.getMoney() + "元\t给" + context.getPayee() + "的银行卡\t" + cardPaymentContext.getAccount());
    }
}
