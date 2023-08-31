package cn.edu.lcu.cs.softwaredesign.basic.relationship;

public class Driver {
    private String name;
//    private Car car;

    public void drive(Car car) {
        car.move();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setModel("比亚迪");
        Driver driver = new Driver();
        driver.drive(car);

        Car car1 = new Car();
        car1.setModel("特斯拉");
        driver.drive(car1);

    }
}
