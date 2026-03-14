package command;

import java.io.File;

import static command.Command.DELIMITER;
import static command.Command.PATH;

public final class Utils {

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
}
