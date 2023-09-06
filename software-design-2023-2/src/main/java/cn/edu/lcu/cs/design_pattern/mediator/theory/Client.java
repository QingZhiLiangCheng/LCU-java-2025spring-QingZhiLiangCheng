package cn.edu.lcu.cs.design_pattern.mediator.theory;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Collegue collegueA = new CollegueA();
        Collegue collegueB = new CollegueB();
        Collegue collegueC = new CollegueC();
        mediator.register(collegueA);
        mediator.register(collegueB);
        mediator.register(collegueC);
        collegueA.send(); // 广播消息，发送给所有人
        System.out.println("----------------------");
        collegueB.send();
    }
}
