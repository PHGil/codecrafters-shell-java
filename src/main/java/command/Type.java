package command;

import java.io.File;

public class Type implements Command {
    private static final String PATH = System.getenv("PATH");
    private static final String DELIMITER = File.pathSeparator;

    public String execute(final String[] args) {
        if (args.length < 2) {
            return "type: missing operand";
        }
        final String command = args[1];
        if (!CommandsEnum.contains(command)) {
            return checkCommandPath(command);
        } else {
            return command + " is a shell builtin";
        }
    }

    private String checkCommandPath(final String command) {
        final String[] paths = PATH.split(DELIMITER);
        for (String path : paths) {
            final File file = new File(path, command);
            if (file.exists() && file.canExecute()) {
                return command + " is " + file.getAbsolutePath();
            }
        }
        return command + " not found";
    }
}