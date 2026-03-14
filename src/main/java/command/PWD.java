package command;

public class PWD implements Command {
    @Override
    public String execute(String[] args) {
        return System.getenv("PWD");
    }
}
