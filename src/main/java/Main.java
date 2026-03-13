void main() throws Exception {
    Scanner scanner = new Scanner(System.in);
    final String echoCommand = "echo ";
    final String typeCommand = "type ";
    final Set<String> builtinCommands = Set.of("type", "echo", "exit");
    while (true) {
        System.out.print("$ ");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            break;
        } else if (input.startsWith(echoCommand)) {
            System.out.println(input.substring(echoCommand.length()));
        } else if (input.startsWith(typeCommand)) {
            final String typeInput = input.substring(typeCommand.length());
            if (!builtinCommands.contains(typeInput)) {
                System.out.println(typeInput + "not found");
            }
            System.out.println(typeInput + "is a shell builtin");
        } else {
            System.out.println(input + ": command not found");
        }

    }
}
