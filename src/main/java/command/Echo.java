package command;

public class Echo implements Command {
    public String execute(String[] args) {
        return args.length < 1 ? "echo: missing operand" : String.join(" ", args);
    }
}