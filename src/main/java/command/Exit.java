package command;

public class Exit implements Command {
    public void execute(String[] args) {
        if (args.length > 1) System.exit(Integer.parseInt(args[1]));
        else System.exit(0);
    }
}
