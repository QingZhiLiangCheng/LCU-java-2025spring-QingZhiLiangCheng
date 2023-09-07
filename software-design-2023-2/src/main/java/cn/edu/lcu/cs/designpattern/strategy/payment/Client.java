package cn.edu.lcu.cs.designpattern.strategy.payment;

public class Client {
    public static void main(String[] args) {
        PaymentStrategy rmbCashPayment = new RMBCashPayment();
        PaymentContext lisiContext = new PaymentContext("lisi", 5000.0, rmbCashPayment);
        lisiContext.pay();

        PaymentStrategy usdCashPayment = new USDCashPayment();
        PaymentContext zhangContext = new PaymentContext("zhangsan", 3000.0, usdCashPayment);
        zhangContext.pay();

        PaymentStrategy rmbCardPayment = new RMBCardPayment("123456789");
        PaymentContext wangContext = new PaymentContext("wangwu", 3000.0, rmbCardPayment);
        wangContext.pay();
    }
}
