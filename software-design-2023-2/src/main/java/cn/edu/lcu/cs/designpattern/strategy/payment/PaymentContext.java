package cn.edu.lcu.cs.designpattern.strategy.payment;

/**
 * 支付环境类，封装支付策略所需的数据。
 */
public class PaymentContext {
    /**
     * 收款人
     */
    private String payee;
    /**
     * 应付工资金额
     */
    private Double salary;

    private PaymentStrategy paymentStrategy;

    public PaymentContext(String payee, Double salary, PaymentStrategy paymentStrategy) {
        this.payee = payee;
        this.salary = salary;
        this.paymentStrategy = paymentStrategy;
    }

    public String getPayee() {
        return payee;
    }

    public Double getSalary() {
        return salary;
    }

    /**
     * 支付工资，由Context传递自己（数据）给策略类。
     */
    public void pay() {
        // 支付工资时，需要从context获取某些信息，如人员姓名、工资数额等
        this.paymentStrategy.pay(this);
    }
}
