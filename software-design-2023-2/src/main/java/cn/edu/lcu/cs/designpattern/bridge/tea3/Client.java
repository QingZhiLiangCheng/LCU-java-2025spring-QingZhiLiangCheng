package cn.edu.lcu.cs.designpattern.bridge.tea3;

public class Client {
    public static void main(String[] args) {
        Cup superCupHotRedTea = new SuperCup(new RedTea(), new HotDrink());
        System.out.println(superCupHotRedTea);

        Cup superCupGreenTea = new SuperCup(new GreenTea(), new IcedDrink());
        System.out.println(superCupGreenTea);

        Cup mediumCupRedTea = new MediumCup(new RedTea());
        System.out.println(mediumCupRedTea);

        Cup mediumCupGreenTea = new MediumCup(new GreenTea());
        System.out.println(mediumCupGreenTea);
    }
}
