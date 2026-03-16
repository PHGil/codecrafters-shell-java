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

        public static String run(final String input) {
            final List<String> tokens = Utils.tokenize(input);
            if (tokens.isEmpty()) return "";

            final String command = tokens.get(0);
            final String[] commandArgs = tokens.subList(1, tokens.size()).toArray(new String[0]);
            final Command cmd = COMMAND_MAP.get(command);

            if (cmd != null) {
                return cmd.execute(commandArgs);
            } else if (Utils.checkIfCommandIsExecutable(command) != null) {
                try {
                    final Process process = Runtime.getRuntime().exec(tokens.toArray(new String[0]));
                    process.waitFor(15, TimeUnit.SECONDS);
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
