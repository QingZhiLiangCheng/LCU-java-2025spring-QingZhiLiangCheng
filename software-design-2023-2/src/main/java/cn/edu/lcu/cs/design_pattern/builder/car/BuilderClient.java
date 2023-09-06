package cn.edu.lcu.cs.design_pattern.builder.car;

import java.util.ArrayList;
import java.util.List;

public class BuilderClient {
    public static void main(String[] args) {
        List<String> sequence = new ArrayList<>();
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");
        BenzBuilder builder = new BenzBuilder();
        builder.setSequence(sequence);
        Car benz = builder.getCar();
        benz.setSequence(sequence);
        benz.run();
    }
}
