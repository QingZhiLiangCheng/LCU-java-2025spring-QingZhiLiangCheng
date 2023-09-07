package cn.edu.lcu.cs.designpattern.command.tv;

public abstract class Command {
    protected Television tv;

    public void setTv(Television tv) {
        this.tv = tv;
    }

    public Command(Television tv) {
        this.tv = tv;
    }

    public Command() {
    }

    public abstract void execute();
}
