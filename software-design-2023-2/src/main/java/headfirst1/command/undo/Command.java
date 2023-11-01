package headfirst1.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
