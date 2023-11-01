package cn.edu.lcu.cs.designpattern.state.cdplayer;

import org.junit.jupiter.api.Test;

class CDPlayerTest {

    @Test
    void control() {
        CDPlayer player = new CDPlayer();
        player.on();
        player.play();
        player.replace(new CD("大学英语四级听力", 30 * 60));
        player.play();
        // 非法调用	PlayingState.replace    播放状态不能更换cd
        player.replace(new CD("大学英语四级听力", 30 * 60));
        player.stop();
        player.replace(new CD("流行歌曲排行榜Top10", 60 * 60));
        player.play();
        player.pause();
        player.play();
        player.off();
        // 非法调用	PowerOffState.pause 停机状态不能暂停
        player.pause();
    }
}