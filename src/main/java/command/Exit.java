package command;

public class Exit implements Command {
    public String execute(String[] args) {
        System.exit(0);
        return null;
    }
}
