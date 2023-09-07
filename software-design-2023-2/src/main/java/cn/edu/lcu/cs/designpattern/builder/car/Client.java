package cn.edu.lcu.cs.designpattern.builder.car;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> sequence = new ArrayList<>();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");
        Benz benz = new Benz();
        benz.setSequence(sequence);
        benz.run();

        Bmw bmw = new Bmw();
        bmw.setSequence(sequence);
        bmw.run();
    }
}
