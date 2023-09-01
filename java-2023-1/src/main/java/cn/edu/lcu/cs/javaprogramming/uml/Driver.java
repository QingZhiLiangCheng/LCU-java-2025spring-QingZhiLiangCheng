package cn.edu.lcu.cs.javaprogramming.uml;

public class Driver {
    private String name;

    public void drive(Car car) {
        car.move();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("特斯拉");
        Driver driver = new Driver();
        driver.drive(car);

        Car car1 = new Car();
        car1.setBrand("比亚迪");
        driver.drive(car1);
    }
}
