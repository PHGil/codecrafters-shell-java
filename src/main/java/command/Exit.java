package command;

public class Exit implements Command {
    @Override
    public String execute(String[] args) {
        System.exit(0);
        return null;
    }
}
