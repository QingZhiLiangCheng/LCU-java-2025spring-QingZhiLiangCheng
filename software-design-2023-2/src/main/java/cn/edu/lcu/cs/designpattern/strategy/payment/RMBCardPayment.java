package cn.edu.lcu.cs.designpattern.strategy.payment;

/**
 * 人民币银行卡支付
 */
public class RMBCardPayment implements PaymentStrategy {
    // 银行卡账号
    private String account;

    public RMBCardPayment(String account) {
        this.account = account;
    }

    @Override
    public void pay(PaymentContext context) {
        System.out.println("支付 ￥" + context.getSalary() + "元\t给" + context.getPayee() + "的银行卡\t" + this.account);
    }
}
