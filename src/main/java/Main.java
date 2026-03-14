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

        public static String run(final String commandName, final String[] args) {
            final Command cmd = COMMAND_MAP.get(commandName);
            if (cmd != null) {
                return cmd.execute(args);
            } else if (Utils.checkIfCommandIsExecutable(commandName) != null) {
                try {
                    final Process process = new ProcessBuilder(commandName).start();
                    process.waitFor();
                    return null;
                } catch (IOException | InterruptedException e) {
                    return "Error executing command: " + e.getMessage();
                }
            } else
                return commandName + ": command not found";
        }
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        final String input = scanner.nextLine();
        final String[] parts = input.split(" +");
        final String command = parts[0];
        final String[] commandArgs = Arrays.copyOfRange(parts, 1, parts.length);
        System.out.println(Commands.run(command, commandArgs));
    }
}
