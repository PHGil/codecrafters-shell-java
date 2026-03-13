import java.util.HashMap;
import java.util.Map;

interface Command {
    void execute(String[] args);
}

class Exit implements Command {
    public void execute(String[] args) {
        if (args.length > 1) System.exit(Integer.parseInt(args[1]));
        else System.exit(0);
    }
}

class Echo implements Command {
    public void execute(String[] args) {
        if (args.length > 1) System.out.println(args[1]);
        else System.out.println("echo: missing operand");
    }
}

class Type implements Command {
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("type: missing operand");
            return;
        }

        String name = args[1];

        Command cmd = Commands.get(name);
        if (cmd != null) {
            System.out.println(name + " is a shell builtin");
        } else {
            System.out.println(name + " not found");
        }
    }
}

public class Commands {
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("exit", new Exit());
        commands.put("echo", new Echo());
        commands.put("type", new Type());
    }

    public static Command get(String name) {
        return commands.get(name);
    }

    public boolean getCommands(String command) {
        return this.commands.containsKey(command);
    }
}
