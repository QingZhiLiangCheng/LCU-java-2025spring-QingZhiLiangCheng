package cn.edu.lcu.cs.designpattern.builder.car;

import java.util.List;

public class BenzBuilder implements CarBuilder {
    private Benz benz = new Benz();

    @Override
    public void setSequence(List<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public Car getCar() {
        return benz;
    }
}
