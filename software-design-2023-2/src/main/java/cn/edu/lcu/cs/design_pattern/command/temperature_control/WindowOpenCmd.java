package cn.edu.lcu.cs.design_pattern.command.temperature_control;

public class WindowOpenCmd implements Command {
    private RoomWindow window;

    public void setWindow(RoomWindow window) {
        this.window = window;
    }

    public WindowOpenCmd(RoomWindow window) {
        this.window = window;
    }

    @Override
    public void execute() {
        window.openWindow();
    }
}
