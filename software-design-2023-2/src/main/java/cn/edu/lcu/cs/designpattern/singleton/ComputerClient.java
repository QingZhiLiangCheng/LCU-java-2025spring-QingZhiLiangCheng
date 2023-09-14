package cn.edu.lcu.cs.designpattern.singleton;

public class ComputerClient {
    public static void main(String[] args) {
//        Computer computer = new Computer();
        Computer computer = Computer.getInstance();
        System.out.println("computer = " + computer);

        System.out.println("Computer.getInstance() = " + Computer.getInstance());
        System.out.println("Computer.getInstance() = " + Computer.getInstance());
        System.out.println("Computer.getInstance() = " + Computer.getInstance());
        System.out.println("Computer.getInstance() = " + Computer.getInstance());

    }
}
