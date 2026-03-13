package command;

public class Echo implements Command {
    public void execute(String[] args) {
        if (args.length > 1) System.out.println(args[1].trim());
        else System.out.println("echo: missing operand");
    }
}