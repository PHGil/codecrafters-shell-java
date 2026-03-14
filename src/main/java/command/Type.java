package command;

public class Type implements Command {


    public String execute(final String[] args) {
        if (args.length < 1) {
            return "type: missing operand";
        }
        final String command = args[0];
        if (!CommandsEnum.contains(command)) {
            final String result = Utils.checkIfCommandIsExecutable(command);
            return result != null ? command + " is " + result : command + " not found";
        } else {
            return command + " is a shell builtin";
        }
    }
}
