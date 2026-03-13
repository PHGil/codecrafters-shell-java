package command;

public class Exit implements Command {
    public void execute(String[] args) {
        System.exit(0);
    }
}
