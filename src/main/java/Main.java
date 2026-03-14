import command.Command;
import command.Echo;
import command.Exit;
import command.Type;

void main() {
    class Commands {
        private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

        static {
            COMMAND_MAP.put("exit", new Exit());
            COMMAND_MAP.put("echo", new Echo());
            COMMAND_MAP.put("type", new Type());
        }

        Commands() {
        }

        public static String run(String... args) {
            final String name = args[0];
            final Command cmd = COMMAND_MAP.get(name);
            if (cmd != null) {
                cmd.initArgs(args);
                cmd.execute(args);
            } else
                return name + ": command not found";
        }
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        final String input = scanner.nextLine();
        final String command = input.split(" ")[0];
        System.out.println(Commands.run(command, input.substring(command.length())));
    }
}
