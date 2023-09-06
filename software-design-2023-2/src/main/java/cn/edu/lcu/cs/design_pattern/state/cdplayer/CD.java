package cn.edu.lcu.cs.design_pattern.state.cdplayer;

/**
 * CD类
 *
 * @author Ling
 */
public class CD {
    /**
     * CD名称
     */
    private String name;
    /**
     * CD播放时长（秒）
     * 本例中暂未使用
     */
    private int durationSeconds;
    /**
     * 已播放时长（秒）
     * 本例中暂未使用
     */
    private int elapsedSeconds;

    public CD(String name, int durationSeconds) {
        this.name = name;
        this.durationSeconds = durationSeconds;
        this.elapsedSeconds = 0;
    }

    public String getName() {
        return name;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public int getElapsedSeconds() {
        return elapsedSeconds;
    }

    public void setElapsedSeconds(int elapsedSeconds) {
        if (elapsedSeconds > durationSeconds) {
            throw new IllegalArgumentException("已播放时长不能大于总时长。");
        }
        this.elapsedSeconds = elapsedSeconds;
    }

    public void reset() {
        this.elapsedSeconds = 0;
    }
}
