package cn.edu.lcu.cs.designpattern.mediator.estateagent;

public class Client {
    public static void main(String[] args) {
        // 创建并显示三个窗口
        CustomerFrame sellerFrame = new CustomerFrame(new Seller("张三（卖家）"));
        sellerFrame.clientWindow(100, 100);
        CustomerFrame buyerFrame = new CustomerFrame(new Buyer("李四（买家）"));
        buyerFrame.clientWindow(400, 100);
        CustomerFrame buyer2Frame = new CustomerFrame(new Buyer("王五（买家）"));
        buyer2Frame.clientWindow(700, 100);
        // 向房屋中介注册
        EstateAgent agent = new EstateAgent();
        agent.register(sellerFrame);
        agent.register(buyerFrame);
        agent.register(buyer2Frame);
    }
}
