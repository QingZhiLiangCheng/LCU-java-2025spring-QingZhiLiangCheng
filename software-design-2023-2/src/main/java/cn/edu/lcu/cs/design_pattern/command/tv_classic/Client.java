package cn.edu.lcu.cs.design_pattern.command.tv_classic;

public class Client {
    public static void main(String[] args) {
        TvController controller = new TvController(new Television());
        controller.open();
        controller.setChannel("中央9台");
        controller.setChannel("聊城大学电视台");
        controller.close();
    }
}
