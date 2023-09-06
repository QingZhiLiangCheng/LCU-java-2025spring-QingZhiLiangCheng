package cn.edu.lcu.cs.design_pattern.command.tv_classic;

import lombok.Data;

@Data
public class TvController {
    private Television tv;
    private String channel;

    public TvController() {
        this.tv = new Television();
    }

    public TvController(Television television) {
        this.tv = television;
    }

    public void open() {
        tv.open();
    }

    public void close() {
        tv.close();
    }


    public void setChannel(String channel) {
        this.channel = channel;
        tv.changeChannel(channel);
    }
}
