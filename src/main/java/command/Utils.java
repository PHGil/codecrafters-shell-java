package command;

import java.io.File;

public final class Utils {
    public static final String PARAMETER_EXTENSION = "$ ";
    
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

    public static boolean isDirectoryPresent(final String path) {
        final File file = new File(path);
        return file.exists() && file.isDirectory();
    }
}
