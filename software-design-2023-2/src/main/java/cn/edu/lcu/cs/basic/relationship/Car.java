package cn.edu.lcu.cs.basic.relationship;

public class Car {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void move() {
//        "车动了".sout
        System.out.println(model + " 车动了");
    }
}
