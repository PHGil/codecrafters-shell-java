import command.*;

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
            final String commandName = args[0];
            final String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);
            final Command cmd = COMMAND_MAP.get(commandName);
            if (cmd != null) {
                cmd.initArgs(args);
                return cmd.execute(args);
            } else if (Utils.checkIfCommandIsExecutable(commandName) != null) {
                return "exec" + Arrays.toString(commandArgs);
            } else
                return commandName + ": command not found";
        }
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        final String input = scanner.nextLine();
        final String command = input.split(" +")[0];
        System.out.println(Commands.run(command, input.substring(command.length())));
    }
}
