package cn.edu.lcu.cs.designpattern.mediator.relaymessage;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Boss boss = new Boss("张青");
        Boss landlady = new Boss("孙二娘");
        Accountant accountant = new Accountant("李会计");
        Saler saler = new Saler("王销售");
        mediator.register(boss);
        mediator.register(landlady);
        mediator.register(accountant);
        mediator.register(saler);

        boss.send("国庆不放假"); // 广播消息
        System.out.println("---------------------");
        saler.send(accountant, "有没有三倍加班费？"); // 单播消息，私信
        System.out.println("---------------------");
        landlady.send("国庆都义务加班啊，不加班节后不用来上班了。"); // 广播消息

    }
}
