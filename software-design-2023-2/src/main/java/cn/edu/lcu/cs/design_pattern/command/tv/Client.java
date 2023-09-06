package cn.edu.lcu.cs.design_pattern.command.tv;

public class Client {
    public static void main(String[] args) {
        TvController controller = new TvController();
        controller.open();
        controller.changeChannel("中央9台");
        controller.close();
    }
}
