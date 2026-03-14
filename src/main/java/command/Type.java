package command;

import java.io.File;

public class Type implements Command {
    private final static String PATH = System.getenv("PATH");
    private final static String DELIMETER = File.pathSeparator;

    public void execute(final String[] args) {
        if (args.length < 2) {
            System.out.println("type: missing operand");
            return;
        }
        final String command = args[1];
        if (!CommandsEnum.contains(command)) {
            System.out.println(checkCommandPath(command));
        } else {
            System.out.println(command + " is a shell builtin");
        }
    }

    private String checkCommandPath(final String command) {
        final String[] paths = PATH.split(DELIMETER);
        for (String path : paths) {
            final File file = new File(path, command);
            if (file.exists() && file.canExecute()) {
                return command + " is " + file.getAbsolutePath();
            }
        }
        return command + " not found";
    }
}