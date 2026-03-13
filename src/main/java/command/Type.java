package command;

public class Type implements Command {
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("type: missing operand");
            return;
        }
        String name = args[1].trim();
        if (!CommandsEnum.contains(name)) {
            System.out.println(name + " not found");
        } else {
            System.out.println(name + " is a shell builtin");
        }
    }
}