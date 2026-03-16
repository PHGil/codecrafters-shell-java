package command;

import java.io.File;
import java.util.ArrayList;

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

    public static ArrayList<String> Arraytokenize(String inputString) {
        ArrayList<String> currentString = new ArrayList<String>();
        StringBuilder buffer = new StringBuilder();
        boolean toggle = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == ' ' && !toggle) {
                if (buffer.length() > 0) {
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
        if (buffer.length() > 0) {
            currentString.add(buffer.toString());
        }

        return currentString;
    }
}
