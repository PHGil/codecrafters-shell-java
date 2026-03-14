package command;

import java.io.File;

public interface Command {
    public static final String PATH = System.getenv("PATH");
    public static final String DELIMITER = File.pathSeparator;

    default void initArgs(String[] args) {
        if (args[1] != null && !args[1].isEmpty()) {
            args[1] = args[1].trim();
        }
    }

    String execute(String[] args);
}
