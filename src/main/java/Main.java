import command.Command;
import command.Echo;
import command.Exit;
import command.Type;

void main() throws Exception {
    class Commands {
        private static final Map<String, Command> commands = new HashMap<>();

        static {
            commands.put("exit", new Exit());
            commands.put("echo", new Echo());
            commands.put("type", new Type());
        }

        public static void run(String... args) {
            final String name = args[0];
            final Command cmd = commands.get(name);
            if (cmd != null) {
                cmd.initArgs(args);
                cmd.execute(args);
            } else
                System.out.println(name + ": command not found");
        }
    }

    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("$ ");
        final String input = scanner.nextLine();
        final String command = input.split(" ")[0];
        Commands.run(command, input.substring(command.length()));
    }
}
