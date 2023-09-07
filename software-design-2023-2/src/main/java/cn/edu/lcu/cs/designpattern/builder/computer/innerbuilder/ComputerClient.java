package cn.edu.lcu.cs.designpattern.builder.computer.innerbuilder;

/**
 * @author ling
 * @date 2022/9/4 22:22
 */
public class ComputerClient {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("因特尔", "三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer);
    }
}
