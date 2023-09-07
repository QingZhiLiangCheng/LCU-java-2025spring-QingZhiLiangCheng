package cn.edu.lcu.cs.designpattern.strategy.payment.cash_payment;

/**
 * 工资支付的策略接口
 * 公司有多种支付工资的算法，如现金、银行卡等
 */
public interface PaymentStrategy {
    /**
     * 支付工资
     *
     * @param payee
     * @param salary
     */
    public void pay(String payee, double salary);
}
