package cn.edu.lcu.cs.designpattern.bridge.tea_cls;

public class Client {
    public static void main(String[] args) {
        Cup superCupRedTea = new SuperCup(new RedTea());
        System.out.println(superCupRedTea);

        Cup superCupGreenTea = new SuperCup(new GreenTea());
        System.out.println(superCupGreenTea);

        Cup mediumCupRedTea = new MediumCup(new RedTea());
        System.out.println(mediumCupRedTea);

        Cup mediumCupGreenTea = new MediumCup(new GreenTea());
        System.out.println(mediumCupGreenTea);
    }
}
