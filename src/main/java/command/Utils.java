package command;

import java.io.File;

public final class Utils {
    private static final String PATH = System.getenv("PATH");
    private static final String DELIMITER = File.pathSeparator;

    Utils() {
    }

    public static String checkIfCommandIsExecutable(final String command) {
        final String[] paths = PATH.split(DELIMITER);
        for (String path : paths) {
            final File file = new File(path, command);
            if (file.exists() && file.canExecute()) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    public static String extractPathFromCommand(final String command) {
        final String[] parts = command.split(" +");
        if (parts.length > 1) {
            return parts[1];
        }
        return null;
    }
}
