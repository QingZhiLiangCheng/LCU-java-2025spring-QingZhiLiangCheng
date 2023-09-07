package cn.edu.lcu.cs.designpattern.facade.smart_house;

import lombok.Getter;

/**
 * @Description 电视机类
 * @Author Ling
 * @Date 2021/9/21 22:02
 * @Version 1.0
 */
@Getter
public class TV {
    /**
     * 电源状态，默认关机
     */
    private boolean powerStatus;

    /**
     * 音量
     */
    private int volume;

    /**
     * 频道
     */
    private String channel;

    public void turnOn() {
        powerStatus = true;
        System.out.println("打开电视机");
    }

    public void turnOff() {
        powerStatus = false;
        System.out.println("关闭电视机");
    }

    public void tuneChannel(String channel) {
        this.channel = channel;
        System.out.println("切换频道到" + this.channel);
    }


    /**
     * 增加音量：当参数为正数时；
     * 减小音量：当参数为负数时。
     *
     * @param volumeDifference 音量差值，增加或减小的幅度
     */
    public void increaseVolume(int volumeDifference) {
        setVolume(this.volume + volumeDifference);
    }

    /**
     * 设置音量
     *
     * @param volume 音量值应该在[0,100]之间，否则设置为0或100.
     */
    public void setVolume(int volume) {
        if (volume < 0) {
            volume = 0;
        } else if (volume > 100) {
            volume = 100;
        } else {
            this.volume = volume;
        }
    }
}
