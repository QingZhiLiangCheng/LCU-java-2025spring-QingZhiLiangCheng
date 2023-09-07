package cn.edu.lcu.cs.designpattern.observer.traffic_pull_thread;

/**
 * 交通灯状态的观察者，救护车
 */
public class Ambulance implements Observer {
    /**
     * 车牌号
     */
    private String plateNumber;

    public Ambulance(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public void response(TrafficLight light) {
        switch (light.getState()) {
            case GREEN:
            case RED:
            case YELLOW:
                System.out.printf("哎哟……哎哟……快给%s让个路\n", plateNumber);
                break;
        }
    }

    @Override
    public void run() {

    }
}
