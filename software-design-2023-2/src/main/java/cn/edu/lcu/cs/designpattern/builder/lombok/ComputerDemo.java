package cn.edu.lcu.cs.designpattern.builder.lombok;

public class ComputerDemo {
    public static void main(String[] args) {
        Computer computer = Computer.builder().board("Dell Board").build();

        System.out.println(computer);

    }
}
