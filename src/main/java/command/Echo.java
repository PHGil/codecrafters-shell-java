package command;

public class Echo implements Command {
    @Override
    public String execute(String[] args) {
        return args.length < 1 ? "echo: missing operand" : String.join(" ", args);
    }
}