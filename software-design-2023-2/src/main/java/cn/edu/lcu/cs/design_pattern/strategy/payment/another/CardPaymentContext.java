package cn.edu.lcu.cs.design_pattern.strategy.payment.another;

/**
 * 银行卡支付上下文，包含银行卡号
 */
public class CardPaymentContext extends PaymentContext {
    private String account;

    public CardPaymentContext(String username, String account, Double money, PaymentStrategy paymentStrategy) {
        super(username, money, paymentStrategy);
        this.account = account;
    }

    public String getAccount() {
        return account;
    }
}
