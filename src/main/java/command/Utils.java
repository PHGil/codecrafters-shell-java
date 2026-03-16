package command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    public static boolean isDirectoryPresent(final String path) {
        final File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    public static List<String> tokenize(String inputString) {
        List<String> currentString = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        boolean toggle = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == ' ' && !toggle) {
                if (!buffer.isEmpty()) {
                    currentString.add(buffer.toString());
                    buffer.setLength(0);
                }
                continue;
            } else if (c == '\'') {
                toggle = !toggle;
                continue;
            }
            buffer.append(c);
        }
        if (!buffer.isEmpty()) {
            currentString.add(buffer.toString());
        }
        return currentString;
    }
}
