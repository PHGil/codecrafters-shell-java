package command;

import java.io.File;

public interface Command {
    public static final String PATH = System.getenv("PATH");
    public static final String DELIMITER = File.pathSeparator;

    String execute(String[] args);
}
