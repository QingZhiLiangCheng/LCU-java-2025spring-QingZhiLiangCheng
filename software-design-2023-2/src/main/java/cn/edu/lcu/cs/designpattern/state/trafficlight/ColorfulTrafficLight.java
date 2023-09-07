package cn.edu.lcu.cs.designpattern.state.trafficlight;

/**
 * 彩色交通灯
 *
 * @Author Ling
 * @Date 2021/10/27 23:54
 * @Version 1.0
 */
public class ColorfulTrafficLight {
    private String color;

    public ColorfulTrafficLight() {
        // 默认颜色
        this.color = "黄色";
    }

    public ColorfulTrafficLight(String color) {
        this.color = color;
    }

    /**
     * 改变颜色。
     */
    private void changeColor() {
        // 后继颜色取决于当前颜色。
        // 所以有复杂的多分支判断。
        switch (color) {
            case "黄色":
                this.color = "红色";
                break;
            case "红色":
                this.color = "绿色";
                // 因为颜色属性是字符串类型，不方便对它的取值进行限制。
                // this.color = "绿灯";
                // this.color = "Green";
                // 交通灯的颜色只有三种，是可枚举的，用枚举类型更合适。
                break;
            case "绿色":
                this.color = "黄色";
                break;
        }
    }

    private void print() {
        System.out.println("当前灯的颜色是 " + color);
    }

    /**
     * 启动交通灯工作，是个无限循环。
     */
    public void start() {
        while (true) {
            // 1、打印当前颜色
            print();
            // 2、休眠若干秒钟
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3、切换颜色
            changeColor();
        }
    }
}
