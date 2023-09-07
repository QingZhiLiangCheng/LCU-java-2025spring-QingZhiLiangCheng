package cn.edu.lcu.cs.designpattern.strategy.payment.another;

public class PaymentContext {
    /**
     * 收款人
     */
    private String payee;
    /**
     * 应付工资金额
     */
    private Double money;

    private PaymentStrategy paymentStrategy;

    public PaymentContext(String username, Double money, PaymentStrategy paymentStrategy) {
        this.payee = username;
        this.money = money;
        this.paymentStrategy = paymentStrategy;
    }

    public String getPayee() {
        return payee;
    }

    public Double getMoney() {
        return money;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    /**
     * 支付工资
     */
    public void pay() {
        // 支付工资时，需要从context获取某些信息，如人员姓名、工资数额等
        this.paymentStrategy.pay(this);
    }
}
