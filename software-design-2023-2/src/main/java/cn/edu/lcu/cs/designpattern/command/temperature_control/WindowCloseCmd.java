package cn.edu.lcu.cs.designpattern.command.temperature_control;

public class WindowCloseCmd implements Command {
    private RoomWindow window;

    public void setWindow(RoomWindow window) {
        this.window = window;
    }

    public WindowCloseCmd(RoomWindow window) {
        this.window = window;
    }

    @Override
    public void execute() {
        window.closeWindow();
    }
}
