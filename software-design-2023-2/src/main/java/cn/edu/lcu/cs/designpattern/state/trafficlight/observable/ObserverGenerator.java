package cn.edu.lcu.cs.designpattern.state.trafficlight.observable;

import java.util.Observer;
import java.util.Random;

/**
 * @description: 观察者发生器
 * @author: ling
 * @since: 2021-11-06 17:59
 **/
public class ObserverGenerator {
    private static Random random = new Random();

    public static Observer generateObserver() {
        int rand = random.nextInt(1000);
        if (rand % 2 == 0) {
            return new Ambulance("鲁P" + rand);
        } else {
            return new Pedestrian("行人" + rand);
        }
    }
}
