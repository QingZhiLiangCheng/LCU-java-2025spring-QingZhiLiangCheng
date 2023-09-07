package cn.edu.lcu.cs.designpattern.bridge.tea_interface;

public class Client {
    public static void main(String[] args) {
        CupSize superCupRedTea = new SuperCup(new RedTea());
        System.out.println(superCupRedTea.getPrice());

        CupSize superCupGreenTea = new SuperCup(new GreenTea());
        System.out.println(superCupGreenTea.getPrice());

        CupSize mediumCupRedTea = new MediumCup(new RedTea());
        System.out.println(mediumCupRedTea.getPrice());

        CupSize mediumCupGreenTea = new MediumCup(new GreenTea());
        System.out.println(mediumCupGreenTea.getPrice());
    }
}
