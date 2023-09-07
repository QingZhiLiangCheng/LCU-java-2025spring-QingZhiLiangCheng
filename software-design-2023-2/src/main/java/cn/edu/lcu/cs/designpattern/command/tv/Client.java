package cn.edu.lcu.cs.designpattern.command.tv;

public class Client {
    public static void main(String[] args) {
        TvController controller = new TvController();
        controller.open();
        controller.changeChannel("中央9台");
        controller.close();
    }
}
