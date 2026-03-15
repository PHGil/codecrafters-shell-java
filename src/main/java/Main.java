import command.*;


void main() {
    class Commands {
        private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

        static {
            COMMAND_MAP.put("exit", new Exit());
            COMMAND_MAP.put("echo", new Echo());
            COMMAND_MAP.put("type", new Type());
            COMMAND_MAP.put("pwd", new PWD());
            COMMAND_MAP.put("cd", new CD());
        }

        Commands() {
        }

        public static String run(final String input) {
            final String[] parts = input.split(" +");
            final String command = parts[0];
            final String[] commandArgs = Arrays.copyOfRange(parts, 1, parts.length);
            System.out.println("Running command: " + command + " with arguments: " + Arrays.toString(commandArgs));
            final Command cmd = COMMAND_MAP.get(command);
            if (cmd != null) {
                return cmd.execute(commandArgs);
            } else if (Utils.checkIfCommandIsExecutable(command) != null) {
                try {
                    final Process process = Runtime.getRuntime().exec(parts);
                    process.waitFor();
                    return new String(process.getInputStream().readAllBytes()).stripTrailing();
                } catch (IOException | InterruptedException e) {
                    return "Error executing command: " + e.getMessage();
                }
            } else
                return command + ": command not found";
        }
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        String result = Commands.run(scanner.nextLine());
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }
}
