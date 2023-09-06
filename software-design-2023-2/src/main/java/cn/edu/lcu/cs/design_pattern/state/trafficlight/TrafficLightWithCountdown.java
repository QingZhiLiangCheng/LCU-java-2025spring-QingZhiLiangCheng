package cn.edu.lcu.cs.design_pattern.state.trafficlight;

import static cn.edu.lcu.cs.design_pattern.state.trafficlight.TrafficLightWithCountdown.TrafficColor.*;

/**
 * <p>带倒计时的交通灯模拟类</p>
 * <p>用枚举模拟其状态</p>
 */
public class TrafficLightWithCountdown {
    private TrafficColor color;

    /**
     * 交通灯的倒计时
     */
    private int countdown;

    public TrafficLightWithCountdown() {
        color = RED;
        countdown = color.getSeconds();
    }

    public TrafficColor getColor() {
        return color;
    }

    /**
     * 启动交通灯
     */
    public void start() {
        while (true) {
            // 显示当前状态
            show();
            try {
                // 休眠1秒钟
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 倒计时减一
            countdown--;
            if (countdown == 0) {
                // 如果倒计时减到0，更新灯的颜色状态
                changeColor();
            }
        }
    }

    /**
     * 状态迁移，更改颜色
     */
    private void changeColor() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
        // 每次状态变更之后，都给倒计时重新赋值
        countdown = color.getSeconds();
    }

    /**
     * 在控制台显示状态
     */
    private void show() {
        // \b 是退格键的意思，删除前边的一个字符
        // bgcolor 是一个字符转义序列，设置控制台文本的背景色
        System.out.print("\b\b\b\b" + color.bgcolor + color.getName() + "  ");

        // 退2格，删除原来显示的秒数，并显示新秒数，占用2个显示位置
        // 修改倒计时
        System.out.printf("\b\b%02d", countdown);
    }

    /**
     * 内部枚举类型
     */
    public enum TrafficColor {
        GREEN("绿灯", 30, "\u001b[1;42m"), YELLOW("黄灯", 5, "\u001b[1;43m"), RED("红灯", 25, "\u001b[1;41m");
        private String name;
        /**
         * 灯亮的总秒数
         */
        private int seconds;
        /**
         * 控制台输出的背景色，仅限IDEA或Eclipse控制台，参见 https://mihai-nita.net/2013/06/03/eclipse-plugin-ansi-in-console/
         */
        private String bgcolor;

        private TrafficColor(String name, int seconds, String bgcolor) {
            this.name = name;
            this.seconds = seconds;
            this.bgcolor = bgcolor;
        }

        public String getName() {
            return name;
        }

        public int getSeconds() {
            return seconds;
        }
    }
}

